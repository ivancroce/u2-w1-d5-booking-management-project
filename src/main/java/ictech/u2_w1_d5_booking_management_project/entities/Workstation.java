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
    private String code;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType type;
    @Column(name = "max_occupants")
    private int maxOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation(String code, String description, WorkstationType type, int maxOccupants, Building building) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.maxOccupants = maxOccupants;
        this.building = building;
    }
}
