package workspace_management.dto.reservation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import workspace_management.entity.Reservation;
import workspace_management.entity.Workspace;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    @Mapping(target = "workspaceID", source = "workspace.id")
    @Mapping(target = "workspaceType", source = "workspace.type")
    UserResponseDto toUserResponseDto(Reservation reservation);

    @Mapping(target = "workspaceID", source = "workspace.id")
    @Mapping(target = "workspaceType", source = "workspace.type")
    @Mapping(target = "customerName", source = "customer.name")
    AdminResponseDto toResponseAdminDto(Reservation reservation);

    Reservation fromRequestDto(BaseReservationDto dto);

    default void updateReservation(Reservation reservation, BaseReservationDto dto,
                                   Workspace workspace) {
        reservation.setStart(dto.getStart());
        reservation.setEnd(dto.getEnd());
        reservation.setWorkspace(workspace);
    }
}
