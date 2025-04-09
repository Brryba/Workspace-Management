package workspace_management.dto.workspace;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
public class IdentifiedWorkspaceDto extends WorkspaceDto {
    @NotNull
    protected int id;

    public IdentifiedWorkspaceDto(int ID, String type, BigDecimal price, boolean available) {
        super(type, price, available);
        this.id = ID;
    }
}
