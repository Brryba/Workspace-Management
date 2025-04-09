package workspace_management.dto.reservation;

import org.springframework.stereotype.Component;
import workspace_management.entity.Reservation;

@Component
public class ReservationMapper {
    public IdentifiedReservationDto toIdDto(Reservation reservation) {
        return new IdentifiedReservationDto(reservation.getReservationID(),
                reservation.getStart(), reservation.getEnd(), reservation.getWorkspaceID());
    }

    public AdminReservationDto toAdminDto(Reservation reservation) {
        return new AdminReservationDto(reservation.getWorkspaceType(),
                reservation.getReservationID(), reservation.getStart(),
                reservation.getEnd(), reservation.getWorkspaceID());
    }

    public Reservation fromDto(ReservationDto dto) {
        Reservation reservation = new Reservation();
        reservation.setWorkspaceID(dto.getWorkspaceID());
        reservation.setStart(dto.getStart());
        reservation.setEnd(dto.getEnd());
        return reservation;
    }
}
