package ictech.u2_w1_d5_booking_management_project.services;

import ictech.u2_w1_d5_booking_management_project.entities.Booking;
import ictech.u2_w1_d5_booking_management_project.entities.User;
import ictech.u2_w1_d5_booking_management_project.entities.Workstation;
import ictech.u2_w1_d5_booking_management_project.exceptions.BookingNotAvailableException;
import ictech.u2_w1_d5_booking_management_project.exceptions.NotFoundException;
import ictech.u2_w1_d5_booking_management_project.repositories.BookingRepository;
import ictech.u2_w1_d5_booking_management_project.repositories.WorkstationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserService userService;

    @Autowired
    WorkstationRepository workstationRepository;

    public void save(String username, long workStationId, LocalDate bookingDate) {
        User user = userService.findByUsername(username);

        Workstation workstation = workstationRepository.findById(workStationId)
                .orElseThrow(() -> new NotFoundException("Workstation with id " + workStationId + " not found!"));

        if (bookingRepository.existsByWorkstationAndBookingDate(workstation, bookingDate)) {
            throw new BookingNotAvailableException("This workstation is already booked for the date: " + bookingDate);
        }

        if (bookingRepository.existsByUserAndBookingDate(user, bookingDate)) {
            throw new BookingNotAvailableException("User '" + username + "' already has a booking for the date: " + bookingDate);
        }

        Booking newBooking = new Booking(bookingDate, user, workstation);

        bookingRepository.save(newBooking);
        log.info("Booking for user '" + username + "' on " + bookingDate + " created successfully!");
    }

    public Booking findById(long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
