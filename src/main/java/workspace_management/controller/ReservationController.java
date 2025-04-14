package workspace_management.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.reservation.AdminResponseDto;
import workspace_management.dto.reservation.RequestDto;
import workspace_management.dto.reservation.UserResponseDto;
import workspace_management.exception.CustomerNotFoundException;
import workspace_management.exception.ReservationNotFoundException;
import workspace_management.exception.WorkspaceNotAvailableException;
import workspace_management.exception.WorkspaceNotFoundException;
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
    public ResponseEntity<List<AdminResponseDto>> showReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<UserResponseDto>> showReservations(@PathVariable(name = "name") @NotBlank String customerName) {
        return new ResponseEntity<>(reservationService.getReservationsByCustomerName(customerName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody @Valid RequestDto baseReservationDto) {
        try {
            return new ResponseEntity<>
                    (reservationService.createReservation(baseReservationDto), HttpStatus.CREATED);
        } catch (WorkspaceNotFoundException | CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (WorkspaceNotAvailableException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation
            (@PathVariable(name = "id") int reservationID, 
             @RequestBody @Valid RequestDto baseReservationDto) {
        try {
            return new ResponseEntity<>(reservationService.updateReservation(reservationID,
                    baseReservationDto), HttpStatus.OK);
        } catch (ReservationNotFoundException | WorkspaceNotFoundException e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (WorkspaceNotAvailableException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable(name = "id") int reservationID) {
        try {
            reservationService.deleteReservation(reservationID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ReservationNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}