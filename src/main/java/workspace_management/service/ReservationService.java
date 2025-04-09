package workspace_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workspace_management.dto.reservation.*;
import workspace_management.entity.Reservation;
import workspace_management.entity.Workspace;
import workspace_management.exception.CustomerNotFoundException;
import workspace_management.exception.ReservationNotFoundException;
import workspace_management.exception.WorkspaceNotAvailableException;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.repository.CustomerRepository;
import workspace_management.repository.ReservationRepository;
import workspace_management.repository.WorkspaceRepository;

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

    public List<AdminResponseDto> getAllReservations() {
        return reservationRepository.findAll().stream().map(mapper::toResponseAdminDto).collect(Collectors.toList());
    }

    public List<UserResponseDto> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findAllByCustomerName(customerName)
                .stream().map(mapper::toUserResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto createReservation(RequestDto reservationDto)
            throws WorkspaceNotFoundException, CustomerNotFoundException, WorkspaceNotAvailableException {
        if (!customerRepository.existsById(reservationDto.getCustomerName())) {
            throw new CustomerNotFoundException();
        }

        Workspace workspace = workspaceRepository.findById(reservationDto.getWorkspaceID())
                .orElseThrow(WorkspaceNotFoundException::new);

        if (!workspace.isAvailable()) {
            throw new WorkspaceNotAvailableException();
        }

        Reservation reservation = mapper.fromRequestDto(reservationDto);
        reservation.setWorkspaceType(workspace.getType());

        reservationRepository.save(reservation);
        workspace.setAvailable(false);
        workspaceRepository.save(workspace);
        return mapper.toUserResponseDto(reservation);
    }

    @Transactional
    public UserResponseDto updateReservation(int reservationID, RequestDto requestDto)
            throws WorkspaceNotFoundException, ReservationNotFoundException, WorkspaceNotAvailableException {

        Reservation reservation = reservationRepository.findById(reservationID)
                .orElseThrow(ReservationNotFoundException::new);
        Workspace workspace = workspaceRepository.findById(requestDto.getWorkspaceID())
                .orElseThrow(WorkspaceNotFoundException::new);
        if (!workspace.isAvailable() && reservation.getWorkspaceID()
                != requestDto.getWorkspaceID()) {
            throw new WorkspaceNotAvailableException();
        }

        mapper.updateReservation(reservation, requestDto,
                workspace.getID(), workspace.getType());
        workspace.setAvailable(false);
        workspaceRepository.save(workspace);
        return mapper.toUserResponseDto(reservationRepository.save(reservation));
    }

    @Transactional
    public void deleteReservation(int reservationID) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationID)
                .orElseThrow(ReservationNotFoundException::new);
        Optional<Workspace> optionalWorkspace = workspaceRepository
                .findById(reservation.getWorkspaceID());

        optionalWorkspace.ifPresent(workspace -> {
            workspace.setAvailable(true);
            workspaceRepository.save(workspace);
        });
        reservationRepository.delete(reservation);
    }
}