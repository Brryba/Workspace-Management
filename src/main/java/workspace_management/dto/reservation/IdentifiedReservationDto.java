package workspace_management.dto.reservation;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class IdentifiedReservationDto extends ReservationDto {
    @NotNull
    protected int id;

    public IdentifiedReservationDto() {}

    public IdentifiedReservationDto(int workspaceID, LocalDateTime start, LocalDateTime end, int id) {
        super(workspaceID, start, end);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
