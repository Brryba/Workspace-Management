package workspace_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workspace_management.dto.customer.CustomerInputDto;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        CustomerInputDto customerInputDto = new CustomerInputDto();
        model.addAttribute("customer", customerInputDto);
        return "index";
    }
}
