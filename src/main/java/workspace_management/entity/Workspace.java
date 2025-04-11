package workspace_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "workspace")
@Getter @Setter
@NoArgsConstructor
public class Workspace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private BigDecimal price;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean available;
}

