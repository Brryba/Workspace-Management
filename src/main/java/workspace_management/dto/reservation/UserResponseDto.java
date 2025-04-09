package workspace_management.dto.reservation;

import java.time.LocalDateTime;

public class UserResponseDto extends BaseReservationDto {
    protected int id;

    public UserResponseDto() {}

    public UserResponseDto(int workspaceID, LocalDateTime start, LocalDateTime end, int id) {
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
