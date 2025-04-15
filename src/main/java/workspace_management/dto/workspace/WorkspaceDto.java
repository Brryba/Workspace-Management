package workspace_management.dto.workspace;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceDto {
    @NotBlank(message = "Workspace type cannot be empty")
    @Size(min = 1, max = 50, message = "Workspace type must be between 1-50 characters")
    protected String type;

    @Digits(integer = 10, fraction = 2, message = "Price must have maximum 2 decimal places")
    protected BigDecimal price;
    protected boolean available;
}
