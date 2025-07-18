package ictech.u2_w1_d5_booking_management_project.entities;

import ictech.u2_w1_d5_booking_management_project.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "workstations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkstationType type;
    @Column(name = "max_occupants", nullable = false)
    private int maxOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    public Workstation(String code, String description, WorkstationType type, int maxOccupants, Building building) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.maxOccupants = maxOccupants;
        this.building = building;
    }
}
