package workspace_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workspace_management.dto.reservation.*;
import workspace_management.entity.Reservation;
import workspace_management.entity.Workspace;
import workspace_management.exception.*;
import workspace_management.repository.CustomerRepository;
import workspace_management.repository.ReservationRepository;
import workspace_management.repository.WorkspaceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final WorkspaceRepository workspaceRepository;
    private final CustomerRepository customerRepository;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository reservationRepository, WorkspaceRepository workspaceRepository, CustomerRepository customerRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.workspaceRepository = workspaceRepository;
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    private boolean isWorkspaceAvailable(int workspaceId, LocalDateTime start, LocalDateTime end) {
        List<Reservation> reservations = reservationRepository.findAllByWorkspaceID(workspaceId);
        return reservations.stream().anyMatch((reservation ->
                reservation.getStart().isAfter(end) || reservation.getEnd().isBefore(start)));
    }

    public List<AdminResponseDto> getAllReservations() {
        return reservationRepository.findAll().stream().map(mapper::toResponseAdminDto).collect(Collectors.toList());
    }

    public List<UserResponseDto> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findAllByCustomerName(customerName)
                .stream().map(mapper::toUserResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto createReservation(RequestReservationDto reservationDto, String customerName) {
        if (!customerRepository.existsById(customerName)) {
            throw new CustomerNotFoundException();
        }

        Workspace workspace = workspaceRepository.findById(reservationDto.getWorkspaceID())
                .orElseThrow(WorkspaceNotFoundException::new);

        if (isWorkspaceAvailable(reservationDto.getWorkspaceID(), reservationDto.getStart(), reservationDto.getEnd())) {
            throw new WorkspaceNotAvailableException();
        }

        Reservation reservation = mapper.fromRequestDto(reservationDto);
        reservation.setCustomerName(customerName);

        reservation.setWorkspaceType(workspace.getType());

        reservationRepository.save(reservation);
        workspaceRepository.save(workspace);
        return mapper.toUserResponseDto(reservation);
    }

    @Transactional
    public UserResponseDto updateReservation(int reservationID, RequestReservationDto requestDto,
                                             String customerName)
           {

        Reservation reservation = reservationRepository.findById(reservationID)
                .orElseThrow(ReservationNotFoundException::new);

        if (!reservation.getCustomerName().equals(customerName)) {
            throw new WrongCustomerException();
        }

        Workspace workspace = workspaceRepository.findById(requestDto.getWorkspaceID())
                .orElseThrow(WorkspaceNotFoundException::new);
        if (!isWorkspaceAvailable(workspace.getId(), requestDto.getStart(), requestDto.getEnd()) && reservation.getWorkspaceID()
                != requestDto.getWorkspaceID()) {
            throw new WorkspaceNotAvailableException();
        }

        mapper.updateReservation(reservation, requestDto,
                workspace.getId(), workspace.getType());
        workspaceRepository.save(workspace);
        return mapper.toUserResponseDto(reservationRepository.save(reservation));
    }

    @Transactional
    public void deleteReservation(int reservationID, String customerName) {
        Reservation reservation = reservationRepository.findById(reservationID)
                .orElseThrow(ReservationNotFoundException::new);


        if (!reservation.getCustomerName().equals(customerName)) {
            throw new WrongCustomerException();
        }

        Optional<Workspace> optionalWorkspace = workspaceRepository
                .findById(reservation.getWorkspaceID());

        optionalWorkspace.ifPresent(workspaceRepository::save);
        reservationRepository.delete(reservation);
    }
}