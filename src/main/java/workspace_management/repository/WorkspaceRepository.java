package workspace_management.repository;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import workspace_management.model.Workspace;

import java.util.List;

@Repository
public class WorkspaceRepository {
    private final EntityManager entityManager;

    public WorkspaceRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void persistWorkspace(Workspace workspace) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(workspace);
        transaction.commit();
    }

    public Workspace getWorkspace(int workspaceID) {
        return this.entityManager.find(Workspace.class, workspaceID);
    }

    public boolean containsWorkspace(int workspaceID) {
        return getWorkspace(workspaceID) != null;
    }

    public List<Workspace> getAllWorkspaces() {
        Query query = this.entityManager.createQuery("from Workspace");
        return query.getResultList();
    }

    public List<Workspace> getAvailableWorkspaces() {
        Query query = this.entityManager.createQuery("from Workspace where isAvailable = true");
        return query.getResultList();
    }

    public void removeWorkspace(int workspaceID) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(getWorkspace(workspaceID));
        this.entityManager.getTransaction().commit();
    }
}
