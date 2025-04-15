package workspace_management.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import workspace_management.dto.reservation.AdminResponseDto;
import workspace_management.dto.reservation.BaseReservationDto;
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
    public ResponseEntity<List<UserResponseDto>> showReservations(@PathVariable("name") @NotBlank String name) {
        if (!name.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            throw new AccessDeniedException("Access denied");
        }
        return new ResponseEntity<>(reservationService.getReservationsByCustomerName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody @Valid BaseReservationDto baseReservationDto) {
        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            return new ResponseEntity<>
                    (reservationService.createReservation(baseReservationDto, customerName),
                            HttpStatus.CREATED);
        } catch (WorkspaceNotFoundException | CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (WorkspaceNotAvailableException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation
            (@PathVariable(name = "id") int reservationID, 
             @RequestBody @Valid BaseReservationDto baseReservationDto) {
        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            return new ResponseEntity<>(reservationService.updateReservation(reservationID,
                    baseReservationDto, customerName), HttpStatus.OK);
        } catch (ReservationNotFoundException | WorkspaceNotFoundException e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (WorkspaceNotAvailableException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (AccessDeniedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable(name = "id") int reservationID) {
        try {
            String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
            reservationService.deleteReservation(reservationID, customerName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ReservationNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}