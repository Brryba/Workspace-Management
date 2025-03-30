package workspace_management.controller;

import org.springframework.stereotype.Controller;
import workspace_management.model.Workspace;
import workspace_management.service.WorkspaceService;

import java.util.List;
import java.util.Optional;

@Controller
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    public void addWorkspace(String type, double price, boolean isAvailable) {
        workspaceService.addWorkspace(type, price, isAvailable);
    }

    public Optional<List<Workspace>> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    public Optional<List<Workspace>> getAvailableWorkspaces() {
        return workspaceService.getAvailableWorkspaces();
    }

    public boolean containsWorkspace(int workspaceID) {
        return workspaceService.containsWorkspace(workspaceID);
    }

    public void deleteWorkspace(int workspaceID) {
        workspaceService.deleteWorkspace(workspaceID);
    }

    public void updateWorkspace(int workspaceId, String type) {
        workspaceService.updateWorkspace(workspaceId, type);
    }

    public void updateWorkspace(int workspaceId, double price) {
        workspaceService.updateWorkspace(workspaceId, price);
    }

    public void updateWorkspace(int workspaceId, boolean isAvailable) {
        workspaceService.updateWorkspace(workspaceId, isAvailable);
    }
}
