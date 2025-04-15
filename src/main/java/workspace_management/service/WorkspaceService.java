package workspace_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workspace_management.dto.workspace.IdentifiedWorkspaceDto;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.dto.workspace.WorkspaceMapper;
import workspace_management.entity.Workspace;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.repository.ReservationRepository;
import workspace_management.repository.WorkspaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    private final ReservationRepository reservationRepository;
    private final WorkspaceMapper mapper;

    public WorkspaceService(WorkspaceRepository workspaceRepository, ReservationRepository reservationRepository, WorkspaceMapper mapper) {
        this.workspaceRepository = workspaceRepository;
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
    }

    public List<IdentifiedWorkspaceDto> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceRepository.findAll();
        return workspaces.stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public List<IdentifiedWorkspaceDto> getAvailableWorkspaces() {
        List<Workspace> workspaces = workspaceRepository
                .findWorkspacesByAvailable(true);
        return workspaces.stream().map(mapper::toIdDto).collect(Collectors.toList());
    }

    public IdentifiedWorkspaceDto createWorkspace(WorkspaceDto workspaceDto) {
        Workspace workspace = mapper.fromDto(workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    public IdentifiedWorkspaceDto updateWorkspace(int id, WorkspaceDto workspaceDto)
            throws WorkspaceNotFoundException {

        Workspace workspace = workspaceRepository.getWorkspacesById(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }
        mapper.updateWorkspace(workspace, workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    @Transactional
    public void deleteWorkspace(int id) throws WorkspaceNotFoundException {
        Workspace workspace = workspaceRepository.getWorkspacesById(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }

        workspaceRepository.delete(workspace);
        reservationRepository.deleteAll(reservationRepository.findAllByWorkspaceID(id));
    }
}