package workspace_management.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.reservation.IdentifiedReservationDto;
import workspace_management.dto.reservation.ReservationDto;
import workspace_management.exception.WorkspaceNotFoundException;
import workspace_management.service.ReservationService;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<IdentifiedReservationDto>> showReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<IdentifiedReservationDto>> showReservations(@PathVariable(name = "name") @NotBlank String customerName) {
        return new ResponseEntity<>(reservationService.getReservationsByCustomerName(customerName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IdentifiedReservationDto> createReservation(@RequestBody @Valid ReservationDto reservationDto) {
        try {
            return new ResponseEntity<>
                    (reservationService.createReservation(reservationDto), HttpStatus.CREATED);
        } catch (WorkspaceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}