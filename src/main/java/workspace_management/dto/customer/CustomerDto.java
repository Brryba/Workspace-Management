package workspace_management.dto.customer;

import jakarta.validation.constraints.Size;

public class CustomerDto {
    @Size(min = 1, max = 100, message = "Name must not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
