package workspace_management.dto.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class UserResponseDto extends BaseReservationDto {
    protected int id;

    public UserResponseDto(int workspaceID, LocalDateTime start, LocalDateTime end, int id) {
        super(workspaceID, start, end);
        this.id = id;
    }
}
