package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.workspace.IdentifiedWorkspaceDto;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.service.WorkspaceService;

import java.util.List;

@Controller
@RequestMapping("/api/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    ResponseEntity<List<IdentifiedWorkspaceDto>> getAllWorkspaces() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        List<IdentifiedWorkspaceDto> workspaces = workspaceService.getAllWorkspaces();
        return new ResponseEntity<>(workspaces,
                HttpStatus.OK);
    }

    @GetMapping("/available")
    ResponseEntity<List<IdentifiedWorkspaceDto>> getAvailableWorkspaces() {
        return new ResponseEntity<>(workspaceService.getAvailableWorkspaces(),
                HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<IdentifiedWorkspaceDto> insertWorkspace(@Valid @RequestBody WorkspaceDto workspaceDto) {
        return new ResponseEntity<>(workspaceService.createWorkspace(workspaceDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<IdentifiedWorkspaceDto> updateWorkspace
            (@PathVariable("id") int workspaceId,
             @Valid @RequestBody WorkspaceDto workspaceDto) {
        try {
            return new ResponseEntity<>(workspaceService.updateWorkspace(workspaceId,
                    workspaceDto), HttpStatus.OK);
        } catch (WorkspaceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> deleteWorkspace(@PathVariable("id") int workspaceId) {
        try {
            workspaceService.deleteWorkspace(workspaceId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (WorkspaceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}