package workspace_management.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import workspace_management.model.Workspace;
import workspace_management.repository.WorkspaceRepository;

import java.util.List;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    private final ReservationService reservationService;

    public WorkspaceService(WorkspaceRepository workspaceRepository, @Lazy ReservationService reservationService) {
        this.workspaceRepository = workspaceRepository;
        this.reservationService = reservationService;
    }

    public void addWorkspace(String type, double price, boolean isAvailable) {
        Workspace workspace = new Workspace();
        workspace.setType(type);
        workspace.setPrice(price);
        workspace.setAvailable(isAvailable);
        workspaceRepository.persistWorkspace(workspace);
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.getAllWorkspaces();
    }

    public List<Workspace> getAvailableWorkspaces() {
        return workspaceRepository.getAvailableWorkspaces();
    }

    public Workspace getWorkspace(int workspaceID) {
        return workspaceRepository.getWorkspace(workspaceID);
    }

    public boolean containsWorkspace(int workspaceId) {
        return workspaceRepository.containsWorkspace(workspaceId);
    }

    public void updateWorkspace(int workspaceId, String type) {
        Workspace workspace = workspaceRepository.getWorkspace(workspaceId);
        workspace.setType(type);
        workspaceRepository.persistWorkspace(workspace);
    }

    public void updateWorkspace(int workspaceId, double price) {
        Workspace workspace = workspaceRepository.getWorkspace(workspaceId);
        workspace.setPrice(price);
        workspaceRepository.persistWorkspace(workspace);
    }

    public void updateWorkspace(int workspaceId, boolean isAvailable) {
        Workspace workspace = workspaceRepository.getWorkspace(workspaceId);
        workspace.setAvailable(isAvailable);
        workspaceRepository.persistWorkspace(workspace);
    }

    public void deleteWorkspace(int workspaceID) {
        reservationService.deleteReservationConnectedToWorkspace(workspaceID);
        workspaceRepository.removeWorkspace(workspaceID);
    }
}
