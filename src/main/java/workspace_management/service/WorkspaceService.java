package workspace_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workspace_management.constants.ReservationConstants;
import workspace_management.dto.workspace.DateRangeDto;
import workspace_management.dto.workspace.IdentifiedWorkspaceDto;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.dto.workspace.WorkspaceMapper;
import workspace_management.entity.Reservation;
import workspace_management.entity.Workspace;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.repository.WorkspaceRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper mapper;

    public WorkspaceService(WorkspaceRepository workspaceRepository, WorkspaceMapper mapper) {
        this.workspaceRepository = workspaceRepository;
        this.mapper = mapper;
    }

    private List<DateRangeDto> getAvailableDateRanges(List<Reservation> reservations) {
        reservations = reservations
                .stream()
                .sorted(Comparator.comparing(Reservation::getStart))
                .toList();

        List<DateRangeDto> availableDateRanges = new ArrayList<>();
        LocalDateTime curr = LocalDateTime.now();
        LocalDateTime end = curr.plusDays(ReservationConstants.MAX_RESERVATION_DAYS);
        for (Reservation reservation : reservations) {
            DateRangeDto dateRange = new DateRangeDto(curr, reservation.getStart());
            if (!dateRange.getStart().equals(dateRange.getEnd())) {
                availableDateRanges.add(dateRange);
            }
            curr = reservation.getEnd();
        }
        availableDateRanges.add(new DateRangeDto(curr, end));
        return availableDateRanges;
    }

    public List<IdentifiedWorkspaceDto> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceRepository.findAll();
        return workspaces
                .stream()
                .map((workspace -> {
                    IdentifiedWorkspaceDto workspaceDto = mapper.toIdDto(workspace);
                    workspaceDto.setAvailableDateRanges(getAvailableDateRanges(workspace.getReservations()));
                    return workspaceDto;
                }))
                .collect(Collectors.toList());
    }

    public List<IdentifiedWorkspaceDto> getAvailableWorkspaces(LocalDateTime start, LocalDateTime end) {
        List<IdentifiedWorkspaceDto> workspaces = getAllWorkspaces();
        return workspaces.stream()
                .filter((workspace) -> {
                    if (workspace.getAvailableDateRanges().isEmpty()) return true;
                    for (DateRangeDto dateRange : workspace.getAvailableDateRanges()) {
                        if (dateRange.getStart().compareTo(start) < 1 && dateRange.getEnd().compareTo(end) > -1) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public IdentifiedWorkspaceDto createWorkspace(WorkspaceDto workspaceDto) {
        Workspace workspace = mapper.fromDto(workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    public IdentifiedWorkspaceDto updateWorkspace(int id, WorkspaceDto workspaceDto) {

        Workspace workspace = workspaceRepository.getWorkspacesById(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }
        mapper.updateWorkspace(workspace, workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return mapper.toIdDto(workspace);
    }

    @Transactional
    public void deleteWorkspace(int id) {
        Workspace workspace = workspaceRepository.getWorkspacesById(id);
        if (workspace == null) {
            throw new WorkspaceNotFoundException();
        }


        workspaceRepository.delete(workspace);
    }
}