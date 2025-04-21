package workspace_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workspace_management.entity.Workspace;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
    Workspace getWorkspacesById(int id);
}