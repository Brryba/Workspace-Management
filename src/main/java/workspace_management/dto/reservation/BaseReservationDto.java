package workspace_management.dto.reservation;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class BaseReservationDto {
    protected int workspaceID;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected LocalDateTime start;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected LocalDateTime end;

    public BaseReservationDto(int workspaceID, LocalDateTime start, LocalDateTime end) {
        this.workspaceID = workspaceID;
        this.start = start;
        this.end = end;
    }

    public BaseReservationDto() {
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