package workspace_management.dto.reservation;

import org.springframework.stereotype.Component;
import workspace_management.entity.Reservation;

@Component
public class ReservationMapper {
    public UserResponseDto toUserResponseDto(Reservation reservation) {
        return new UserResponseDto(reservation.getReservationID(),
                reservation.getStart(), reservation.getEnd(), reservation.getWorkspaceID());
    }

    public AdminResponseDto toResponseAdminDto(Reservation reservation) {
        return new AdminResponseDto(reservation.getCustomerName(),
                reservation.getReservationID(), reservation.getStart(),
                reservation.getEnd(), reservation.getWorkspaceID());
    }

    public Reservation fromRequestDto(RequestDto dto) {
        Reservation reservation = new Reservation();
        reservation.setWorkspaceID(dto.getWorkspaceID());
        reservation.setStart(dto.getStart());
        reservation.setEnd(dto.getEnd());
        reservation.setCustomerName(dto.getCustomerName());
        return reservation;
    }

    public void updateReservation(Reservation reservation, RequestDto dto,
                                  int workspaceID, String workspaceType) {
        reservation.setStart(dto.getStart());
        reservation.setEnd(dto.getEnd());
        reservation.setWorkspaceID(workspaceID);
        reservation.setWorkspaceType(workspaceType);
    }
}
