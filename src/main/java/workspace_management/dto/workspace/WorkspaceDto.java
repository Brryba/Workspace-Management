package workspace_management.dto.workspace;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class WorkspaceDto {
    @NotBlank(message = "type must not be empty")
    @Size(min = 1, max = 50, message = "type length should not be bigger than 50")
    private String type;
    @Digits(integer = 10, fraction = 2, message = "Can not have more than 99 cents")
    private BigDecimal price;
    private boolean available;

    public WorkspaceDto() {
    }

    public WorkspaceDto(String type, BigDecimal price, boolean available) {
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
