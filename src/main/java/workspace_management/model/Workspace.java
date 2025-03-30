package workspace_management.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "workspace")
public class Workspace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String type;
    private BigDecimal price;
    @Column(columnDefinition = "true")
    private boolean isAvailable = true;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_DOWN);
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Workplace ID: " + this.ID +
                "\nType: " + this.type +
                "\nPrice: " + this.price +
                "\nAvailability Status: " + (isAvailable ? "Available" : "Not Available\n");
    }
}

