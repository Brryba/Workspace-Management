package workspace_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workspace_management.entity.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAllByCustomerName(String customerName);

    List<Reservation> findAllByWorkspaceID(int workspaceID);
}