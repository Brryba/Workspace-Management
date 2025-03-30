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

    public Reservation(String customerName, int workplaceID, String workspaceType) {
        this.customerName = customerName;
        this.workspaceID = workplaceID;
        this.workspaceType = workspaceType;
    }

    public Reservation() {

    }

    private LocalDateTime parseDateTime(String date, String time) {
        String dateTime = date.trim() + " " + time.trim();
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public void setStart(String date, String time) {
        this.start = parseDateTime(date, time);
    }

    public void setStart(Timestamp timestamp) {
        this.start = timestamp.toLocalDateTime();
    }

    public void setEnd(Timestamp timestamp) {
        this.end = timestamp.toLocalDateTime();
    }

    public void setEnd(String date, String time) {
        this.end = parseDateTime(date, time);
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getWorkspaceID() {
        return this.workspaceID;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + this.reservationID +
                "\nWorkplace ID: " + this.workspaceID +
                "\nWorkplace name: " + this.workspaceType +
                "\nStart Time: " + start.format(dateTimeFormatter) +
                "\nEnd Time: " + end.format(dateTimeFormatter);
    }

    public String toStringAdmin() {
        return "Customer Name:" + this.customerName +
                "\n" + this;
    }
}
