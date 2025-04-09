package workspace_management.dto.workspace;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class IdentifiedWorkspaceDto extends WorkspaceDto {
    @NotNull
    protected int id;

    public IdentifiedWorkspaceDto() {
    }

    public IdentifiedWorkspaceDto(int ID, String type, BigDecimal price, boolean available) {
        super(type, price, available);
        this.id = ID;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }
}
