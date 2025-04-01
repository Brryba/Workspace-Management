package workspace_management.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import workspace_management.event.WorkspaceDeletedEvent;
import workspace_management.model.Reservation;
import workspace_management.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService implements ApplicationListener<WorkspaceDeletedEvent> {
    private final ReservationRepository reservationRepository;
    private final WorkspaceService workspaceService;

    public ReservationService(ReservationRepository reservationRepository, WorkspaceService workspaceService) {
        this.reservationRepository = reservationRepository;
        this.workspaceService = workspaceService;
    }

    public void createNewReservation(String customerName, int workspaceID,
                                     LocalDateTime startDate, LocalDateTime endDate) {
        Reservation reservation = new Reservation(customerName, workspaceID, startDate, endDate);
        reservation.setWorkspaceType(workspaceService.getWorkspace(workspaceID).getType());
        reservationRepository.insertReservation(reservation);
        workspaceService.updateWorkspace(workspaceID, false);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getReservations();
    }

    public List<Reservation> getReservations(String customerName) {
        return reservationRepository.getReservations(customerName);
    }

    public void deleteReservationConnectedToWorkspace(int workspaceID) {
        reservationRepository.getReservationByWorkspaceID(workspaceID)
                .ifPresent(reservationRepository::deleteReservation);
    }

    public void deleteReservation(int reservationID) {
        Reservation reservation = reservationRepository.getReservation(reservationID).get();
        workspaceService.updateWorkspace(reservation.getWorkspaceID(), true);
        reservationRepository.deleteReservation(reservation);
    }

    @Override
    public void onApplicationEvent(WorkspaceDeletedEvent event) {
        deleteReservationConnectedToWorkspace(event.getWorkspaceID());
    }
}
