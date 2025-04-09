package workspace_management.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import workspace_management.dto.workspace.IdentifiedWorkspaceDto;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.dto.workspace.WorkspaceMapper;
import workspace_management.entity.Workspace;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.repository.WorkspaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    public final ApplicationEventPublisher applicationEventPublisher;
    private final WorkspaceMapper mapper;

    public WorkspaceService(WorkspaceRepository workspaceRepository, ApplicationEventPublisher applicationEventPublisher, WorkspaceMapper mapper) {
        this.workspaceRepository = workspaceRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.mapper = mapper;
    }

    public List<IdentifiedWorkspaceDto> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceRepository.findAll();
        return workspaces.stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public List<IdentifiedWorkspaceDto> getAvailableWorkspaces() {
        List<Workspace> workspaces = workspaceRepository
                .findWorkspacesByisAvailable(true);
        return workspaces.stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public IdentifiedWorkspaceDto createWorkspace(WorkspaceDto workspaceDto) {
        Workspace workspace = mapper.fromDto(workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    public IdentifiedWorkspaceDto updateWorkspace(int id, WorkspaceDto workspaceDto)
            throws WorkspaceNotFoundException {

        Workspace workspace = workspaceRepository.getWorkspacesByID(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }
        this.setWorkspace(workspace, workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    public void deleteWorkspace(int id) throws WorkspaceNotFoundException {
        Workspace workspace = workspaceRepository.getWorkspacesByID(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }

        workspaceRepository.delete(workspace);
    }

    private void setWorkspace(Workspace workspace, WorkspaceDto workspaceDto) {
        workspace.setType(workspaceDto.getType());
        workspace.setPrice(workspaceDto.getPrice());
        workspace.setAvailable(workspaceDto.isAvailable());
    }
}