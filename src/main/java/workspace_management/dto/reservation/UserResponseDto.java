package workspace_management.dto.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserResponseDto extends BaseReservationDto {
    protected int reservationID;
    protected String workspaceType;
}
