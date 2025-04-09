package workspace_management.dto.workspace;

import org.springframework.stereotype.Component;
import workspace_management.entity.Workspace;

@Component
public class WorkspaceMapper {
    public IdentifiedWorkspaceDto toIdDto(Workspace workspace) {
        return new IdentifiedWorkspaceDto(workspace.getID(), workspace.getType(),
                workspace.getPrice(), workspace.isAvailable());
    }

    public Workspace fromDto(WorkspaceDto workspaceDto) {
        return new Workspace(workspaceDto.getType(), workspaceDto.getPrice(), workspaceDto.isAvailable());
    }

    public void updateWorkspace(Workspace workspace, WorkspaceDto workspaceDto) {
        workspace.setType(workspaceDto.getType());
        workspace.setPrice(workspaceDto.getPrice());
        workspace.setAvailable(workspaceDto.isAvailable());
    }
}
