package workspace_management.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

public class WorkspaceDto {
    private int id;
    @Size(min = 1, max = 50)
    private String type;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private String price;
    private boolean available;
    private boolean existing = false;

    public WorkspaceDto() {
    }

    public WorkspaceDto(int id, String type, String price, boolean available, boolean existing) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.available = available;
        this.existing = existing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }
}
