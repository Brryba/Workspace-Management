package workspace_management.dto.workspace;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class IdentifiedWorkspaceDto extends WorkspaceDto {
    @NotNull
    protected int id;
}
