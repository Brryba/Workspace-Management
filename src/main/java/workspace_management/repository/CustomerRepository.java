package workspace_management.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import workspace_management.model.Customer;

@Repository
public class CustomerRepository {
    private final EntityManager entityManager;

    public CustomerRepository(EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Customer findCustomer(String customerName) {
        return this.entityManager
                .find(Customer.class, customerName);
    }

    public void insertCustomer(String customerName) {
        EntityTransaction transaction = entityManager.getTransaction();
        Customer customer = new Customer();
        customer.setName(customerName);
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }
}