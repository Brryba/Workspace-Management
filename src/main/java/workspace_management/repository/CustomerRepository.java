package workspace_management.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import workspace_management.model.Customer;

@Repository
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Customer findCustomer(String customerName) {
        return this.entityManager
                .find(Customer.class, customerName);
    }

    public void insertCustomer(String customerName) {
        Customer customer = new Customer();
        customer.setName(customerName);
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(customer);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        }
    }
}
