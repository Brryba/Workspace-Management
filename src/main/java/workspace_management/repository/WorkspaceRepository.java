package workspace_management.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import workspace_management.model.Workspace;

import java.util.List;

@Repository
public class WorkspaceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void persistWorkspace(Workspace workspace) throws HibernateException {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(workspace);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            throw e;
        }
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

    public void removeWorkspace(int workspaceID) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(getWorkspace(workspaceID));
        this.entityManager.getTransaction().commit();
    }
}
