package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.workspace.IdentifiedWorkspaceDto;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.service.WorkspaceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<IdentifiedWorkspaceDto> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    List<IdentifiedWorkspaceDto> getAvailableWorkspaces() {
        return workspaceService.getAvailableWorkspaces();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    IdentifiedWorkspaceDto insertWorkspace(@Valid @RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    IdentifiedWorkspaceDto updateWorkspace(@PathVariable("id") int workspaceId, @Valid @RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.updateWorkspace(workspaceId, workspaceDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWorkspace(@PathVariable("id") int workspaceId) {
        workspaceService.deleteWorkspace(workspaceId);
    }

    @ExceptionHandler(WorkspaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String workspaceNotFound(WorkspaceNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String methodArgumentNotValid(MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}