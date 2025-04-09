package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.dto.reservation.IdentifiedReservationDto;
import workspace_management.dto.reservation.ReservationDto;
import workspace_management.dto.reservation.ReservationMapper;
import workspace_management.entity.Reservation;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.repository.ReservationRepository;
import workspace_management.repository.WorkspaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final WorkspaceRepository workspaceRepository;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository reservationRepository, WorkspaceRepository workspaceRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.workspaceRepository = workspaceRepository;
        this.mapper = mapper;
    }

    public List<IdentifiedReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public List<IdentifiedReservationDto> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findAllByCustomerName(customerName)
                .stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public IdentifiedReservationDto createReservation(ReservationDto reservationDto) throws WorkspaceNotFoundException {
        if (!workspaceRepository.existsById(reservationDto.getWorkspaceID())) {
            throw new WorkspaceNotFoundException();
        }

        Reservation reservation = reservationRepository.save(mapper.fromDto(reservationDto));
        return mapper.toIdDto(reservation);
    }
}