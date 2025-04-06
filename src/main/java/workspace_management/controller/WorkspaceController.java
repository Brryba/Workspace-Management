package workspace_management.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.workspace.WorkspaceDto;
import workspace_management.model.Workspace;
import workspace_management.service.WorkspaceService;

import java.util.List;

@Controller
@RequestMapping("/workspace")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping("/create")
    public String createWorkspace(Model model) {
        model.addAttribute("workspaceInfo", new WorkspaceDto());
        return "workspace-update";
    }

    @GetMapping
    public String getWorkspace(@RequestParam(name="id") Integer id, Model model) {
        Workspace workspace = workspaceService.getWorkspace(id);
        model.addAttribute("workspaceInfo",
                new WorkspaceDto(workspace.getID(), workspace.getType(),
                        workspace.getPrice().toString(), workspace.isAvailable(), true));
        return "workspace-update";
    }

    @PostMapping("/edit")
    public String updateWorkspace(@ModelAttribute(name = "workspaceInfo")
                                      @Valid WorkspaceDto workspaceInfo, BindingResult result) {
        if (result.hasErrors()) {
            return "workspace-update";
        }

        workspaceService.updateWorkspace(workspaceInfo);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteWorkspace(@RequestParam(name = "id") int workspaceID) {
        workspaceService.deleteWorkspace(workspaceID);
        return "redirect:/admin";
    }
}
