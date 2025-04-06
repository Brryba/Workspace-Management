package workspace_management.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workspace_management.dto.CustomerDto;

@Controller
@RequestMapping("/")
public class StartPageController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "index";
    }
}
