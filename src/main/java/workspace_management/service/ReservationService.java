package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.repository.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final WorkspaceService workspaceService;

    public ReservationService(ReservationRepository reservationRepository, WorkspaceService workspaceService) {
        this.reservationRepository = reservationRepository;
        this.workspaceService = workspaceService;
    }
}
