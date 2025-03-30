package workspace_management.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationID;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "workspace_id")
    private int workspaceID;
    @Column(name = "workspace_type")
    private String workspaceType;
    private LocalDateTime start;
    private LocalDateTime end;
    private static final DateTimeFormatter dateTimeFormatter
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Reservation(String customerName, int workspaceID, LocalDateTime start, LocalDateTime end) {
        this.customerName = customerName;
        this.workspaceID = workspaceID;
        this.start = start;
        this.end = end;
    }

    public Reservation() {

    }

    private LocalDateTime parseDateTime(String date, String time) {
        String dateTime = date.trim() + " " + time.trim();
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public void setWorkspaceType(String workspaceType) {
        this.workspaceType = workspaceType;
    }

    public int getReservationID() {
        return reservationID;
    }

    public int getWorkspaceID() {
        return this.workspaceID;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + this.reservationID +
                "\nWorkplace ID: " + this.workspaceID +
                "\nWorkplace name: " + this.workspaceType +
                "\nStart Time: " + start.format(dateTimeFormatter) +
                "\nEnd Time: " + end.format(dateTimeFormatter) + "\n";
    }

    public String toStringAdmin() {
        return "Customer Name: " + this.customerName +
                "\n" + this + "\n";
    }
}
