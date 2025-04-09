package workspace_management.dto.reservation;

import java.time.LocalDateTime;

public class AdminResponseDto extends UserResponseDto {
    private String customerName;

    public AdminResponseDto() {
    }

    public AdminResponseDto(String customerName, int workspaceID, LocalDateTime start, LocalDateTime end, int id) {
        super(workspaceID, start, end, id);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
