package workspace_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter @Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationID;
    @ManyToOne
    private Customer customer;
    @Column(name = "workspace_id")
    private int workspaceID;
    @Column(name = "workspace_type")
    private String workspaceType;
    private LocalDateTime start;
    private LocalDateTime end;
}
