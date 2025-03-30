package workspace_management.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import workspace_management.model.Reservation;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    //@PersistenceContext
    private EntityManager entityManager;

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

    public Optional<List<Reservation>> getReservations() {
        Query query = entityManager.createQuery("FROM Reservation");
        List<Reservation> reservations = query.getResultList();
        return reservations.isEmpty() ? Optional.empty() : Optional.of(reservations);
    }

    public Optional<List<Reservation>> getReservations(String customerName) {
        Query query = entityManager.createQuery("FROM Reservation WHERE customerName = :name");
        query.setParameter("name", customerName);
        List<Reservation> reservations = query.getResultList();
        return reservations.isEmpty() ? Optional.empty() : Optional.of(reservations);
    }

    public void deleteReservation(Reservation reservation) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(reservation);
        this.entityManager.getTransaction().commit();
    }
}
