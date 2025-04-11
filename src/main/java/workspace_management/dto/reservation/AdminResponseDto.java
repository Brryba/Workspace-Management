package workspace_management.dto.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AdminResponseDto extends UserResponseDto {
    private String customerName;
}
