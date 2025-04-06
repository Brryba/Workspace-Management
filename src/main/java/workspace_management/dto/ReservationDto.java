package workspace_management.dto;

import java.time.LocalDateTime;

public class ReservationDto {
    private String customerName;
    private int workspaceID;
    private LocalDateTime start;
    private LocalDateTime end;

    public ReservationDto(String customerName, int workspaceID, LocalDateTime start, LocalDateTime end) {
        this.customerName = customerName;
        this.workspaceID = workspaceID;
        this.start = start;
        this.end = end;
    }

    public ReservationDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getWorkspaceID() {
        return workspaceID;
    }

    public void setWorkspaceID(int workspaceID) {
        this.workspaceID = workspaceID;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}