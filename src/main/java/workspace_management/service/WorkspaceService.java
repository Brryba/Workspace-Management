package workspace_management.service;

import org.springframework.stereotype.Service;
import workspace_management.repository.WorkspaceRepository;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    private int workspaceId;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public int getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(int workspaceId) {
        this.workspaceId = workspaceId;
    }
}
