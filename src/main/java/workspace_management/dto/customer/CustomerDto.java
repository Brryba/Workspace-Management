package workspace_management.dto.customer;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerDto {
    @Size(min = 1, max = 100, message = "Name must not be empty")
    private String name;
    @Size(min = 1, max = 100)
    private String password;
}
