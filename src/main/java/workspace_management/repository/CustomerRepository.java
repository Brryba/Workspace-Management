package workspace_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workspace_management.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}