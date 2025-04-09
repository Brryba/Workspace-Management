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
    @NotBlank(message = "type must not be empty")
    @Size(min = 1, max = 50, message = "type length should not be bigger than 50")
    protected String type;
    @Digits(integer = 10, fraction = 2, message = "Can not have more than 99 cents")
    protected BigDecimal price;
    protected boolean available;
}
