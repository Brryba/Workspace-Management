package workspace_management.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.reservation.AdminResponseDto;
import workspace_management.dto.reservation.BaseReservationDto;
import workspace_management.dto.reservation.RequestReservationDto;
import workspace_management.dto.reservation.UserResponseDto;
import workspace_management.exception.*;
import workspace_management.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AdminResponseDto> showReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDto> showReservations(@PathVariable("name") @NotBlank String name) {
        if (!name.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            throw new WrongCustomerException();
        }
        return reservationService.getReservationsByCustomerName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createReservation(@RequestBody @Valid RequestReservationDto baseReservationDto) {
        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        return reservationService.createReservation(baseReservationDto, customerName);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto updateReservation(@PathVariable(name = "id") int reservationID,
                                               @RequestBody @Valid RequestReservationDto baseReservationDto) {

        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        return reservationService.updateReservation(reservationID, baseReservationDto, customerName);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable(name = "id") int reservationID) {
        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        reservationService.deleteReservation(reservationID, customerName);
    }
}