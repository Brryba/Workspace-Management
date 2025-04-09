package workspace_management.dto.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class AdminResponseDto extends UserResponseDto {
    private String customerName;

    public AdminResponseDto(String customerName, int workspaceID, LocalDateTime start, LocalDateTime end, int id) {
        super(workspaceID, start, end, id);
        this.customerName = customerName;
    }
}
