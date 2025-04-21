package workspace_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workspace_management.entity.Workspace;

import java.util.List;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
    //List<Workspace> findWorkspacesByAvailable(boolean available);

    Workspace getWorkspacesById(int id);
}