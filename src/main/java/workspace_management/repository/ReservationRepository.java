package workspace_management.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import workspace_management.model.Reservation;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    private final EntityManager entityManager;

    public ReservationRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertReservation(Reservation reservation) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(reservation);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            this.entityManager.getTransaction().rollback();
            System.err.println(e.getMessage());
        }
    }

    public Optional<Reservation> getReservation(int reservationID) {
        return Optional.ofNullable(this.entityManager.find(Reservation.class, reservationID));
    }

    public List<Reservation> getReservations() {
        Query query = entityManager.createQuery("FROM Reservation");
        return query.getResultList();
    }

    public List<Reservation> getReservations(String customerName) {
        Query query = entityManager.createQuery("FROM Reservation WHERE customerName = :name");
        query.setParameter("name", customerName);
        return query.getResultList();
    }

    public Optional<Reservation> getReservationByWorkspaceID(int workspaceID) {
        Query query = entityManager.createQuery("FROM Reservation WHERE workspaceID = :workspaceID");
        query.setParameter("workspaceID", workspaceID);
        List<Reservation> reservations = query.getResultList();
        if (reservations.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(reservations.getFirst());
    }

    public void deleteReservation(Reservation reservation) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(reservation);
        this.entityManager.getTransaction().commit();
    }
}
