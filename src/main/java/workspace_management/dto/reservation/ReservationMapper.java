package workspace_management.dto.reservation;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import workspace_management.entity.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    UserResponseDto toUserResponseDto(Reservation reservation);

    AdminResponseDto toResponseAdminDto(Reservation reservation);

    Reservation fromRequestDto(BaseReservationDto dto);

    default void updateReservation(Reservation reservation, BaseReservationDto dto,
                                  int workspaceID, String workspaceType) {
        reservation.setStart(dto.getStart());
        reservation.setEnd(dto.getEnd());
        reservation.setWorkspaceID(workspaceID);
        reservation.setWorkspaceType(workspaceType);
    }
}
