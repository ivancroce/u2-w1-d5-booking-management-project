package ictech.u2_w1_d5_booking_management_project.repositories;

import ictech.u2_w1_d5_booking_management_project.entities.Booking;
import ictech.u2_w1_d5_booking_management_project.entities.User;
import ictech.u2_w1_d5_booking_management_project.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByUserAndBookingDate(User user, LocalDate bookingDate);

    boolean existsByWorkstationAndBookingDate(Workstation workstation, LocalDate bookingDate);
}
