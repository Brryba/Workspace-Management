package workspace_management.dto.reservation;

import jakarta.validation.constraints.AssertTrue;
import org.springframework.format.annotation.DateTimeFormat;
import workspace_management.constants.ReservationConstants;

import java.time.LocalDateTime;

public class RequestReservationDto extends BaseReservationDto {
    @AssertTrue(message = "Start time must be before end time")
    public boolean isStartBeforeEnd() {
        return start.isBefore(end);
    }

    @AssertTrue(message = "Reservation must end within one year from today")
    public boolean isEndWithinOneYear() {
        return end.isBefore(LocalDateTime.now().plusDays(ReservationConstants.MAX_RESERVATION_DAYS));
    }

    @AssertTrue(message = "You can not make a reservation in the past")
    public boolean isStartInFuture() {
        return start.isAfter(LocalDateTime.now());
    }
}
