package workspace_management.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;

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
    @Column(name = "IsAvailable", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isAvailable = true;

    public Workspace() {
    }

    public Workspace(int ID, String type, BigDecimal price, boolean isAvailable) {
        this.ID = ID;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }

    public boolean isAvailable() {
        return isAvailable;
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

