package workspace_management.dto.reservation;

import java.time.LocalDateTime;

public class RequestDto extends BaseReservationDto {
    protected String customerName;

    public RequestDto(int workspaceID, LocalDateTime start, LocalDateTime end, String customerName) {
        super(workspaceID, start, end);
        this.customerName = customerName;
    }

    public RequestDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
