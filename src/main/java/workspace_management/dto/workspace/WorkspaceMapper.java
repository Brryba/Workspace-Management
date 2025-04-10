package workspace_management.dto.workspace;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import workspace_management.entity.Workspace;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkspaceMapper {
    IdentifiedWorkspaceDto toIdDto(Workspace workspace);

    Workspace fromDto(WorkspaceDto workspaceDto);

    default void updateWorkspace(Workspace workspace, WorkspaceDto workspaceDto) {
        workspace.setType(workspaceDto.getType());
        workspace.setPrice(workspaceDto.getPrice());
        workspace.setAvailable(workspaceDto.isAvailable());
    }
}
