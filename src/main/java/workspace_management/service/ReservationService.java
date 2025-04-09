package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.dto.reservation.IdentifiedReservationDto;
import workspace_management.dto.reservation.ReservationMapper;
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
}