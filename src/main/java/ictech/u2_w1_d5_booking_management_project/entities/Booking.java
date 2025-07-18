package ictech.u2_w1_d5_booking_management_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

    public Booking(LocalDate bookingDate, User user, Workstation workstation) {
        this.bookingDate = bookingDate;
        this.user = user;
        this.workstation = workstation;
    }
}
