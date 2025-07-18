package ictech.u2_w1_d5_booking_management_project.runners;

import ictech.u2_w1_d5_booking_management_project.entities.Building;
import ictech.u2_w1_d5_booking_management_project.entities.User;
import ictech.u2_w1_d5_booking_management_project.entities.Workstation;
import ictech.u2_w1_d5_booking_management_project.enums.WorkstationType;
import ictech.u2_w1_d5_booking_management_project.services.BookingService;
import ictech.u2_w1_d5_booking_management_project.services.BuildingService;
import ictech.u2_w1_d5_booking_management_project.services.UserService;
import ictech.u2_w1_d5_booking_management_project.services.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookingRunner implements CommandLineRunner {
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WorkstationService workstationService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Override
    public void run(String... args) throws Exception {
        // Buildings
        Building metaBuilding = new Building("Meta", "4 Grand Canal Square, Grand Canal Dock", "Dublin");
        Building googleBuilding = new Building("Google", "Brandschenkestrasse 110", "Zurich");
        Building microsoftBuilding = new Building("Microsoft", "11 Times Square, 8th Ave & 41st St", "New York");

       /* buildingService.save(metaBuilding);
        buildingService.save(googleBuilding);
        buildingService.save(microsoftBuilding);*/

        // Users
        User aldoBaglio = new User("aldo.baglio", "Aldo Baglio", "aldo.baglio@example.com");
        User giovanniStorti = new User("giovanni.storti", "Giovanni Storti", "giovanni.storti@example.com");
        User giacomoPoretti = new User("giacomo.poretti", "Giacomo Poretti", "giacomo.poretti@example.com");

        /*userService.save(aldoBaglio);
        userService.save(giovanniStorti);
        userService.save(giacomoPoretti);*/

        // Workstations
        Building metaBuildingFromDb = buildingService.findById(1);
        Building googleBuildingFromDb = buildingService.findById(2);
        Building microsoftBuildingFromDb = buildingService.findById(3);

        Workstation metaPrivateOffice = new Workstation("DUB-PR-01", "Private office", WorkstationType.PRIVATE, 1, metaBuildingFromDb);
        Workstation googleMeetingRoom = new Workstation("ZUR-MR-01", "Meeting Room", WorkstationType.MEETING_ROOM, 8, googleBuildingFromDb);
        Workstation microsoftMeetingRoom = new Workstation("NYC-OS-01", "Openspace area", WorkstationType.OPENSPACE, 1, microsoftBuildingFromDb);

        /*workstationService.save(metaPrivateOffice);
        workstationService.save(googleMeetingRoom);
        workstationService.save(microsoftMeetingRoom);*/

        // Bookings
        String aldoUsername = "aldo.baglio";
        String giovanniUsername = "giovanni.storti";
        long metaOfficeId = 1L;
        long googleMeetingRoomId = 2L;

        LocalDate testDate = LocalDate.now().plusDays(15);

        /*try {
            // System.out.println("[Attempt 1] Aldo Baglio is booking the private office in Dublin");
            //  bookingService.save(aldoUsername, metaOfficeId, testDate);
        } catch (BookingNotAvailableException e) {
            System.out.println(e.getMessage());
        }*/

        /*try {
            //  System.out.println("[Attempt 2] Giovanni Storti tries to book the SAME spot for the SAME day");
            //  bookingService.save(giovanniUsername, metaOfficeId, testDate);
        } catch (BookingNotAvailableException e) {
            System.out.println(e.getMessage());
        }*/

        /*try {
           //  System.out.println("[Attempt 3] Aldo Baglio is booking the same private office in Dublin but different date");
           //  bookingService.save(aldoUsername, metaOfficeId, testDate.plusDays(7));
        } catch (BookingNotAvailableException e) {
            System.out.println(e.getMessage());
        }*/

        /*try {
           //  System.out.println("[Attempt 4] Giovanni Storti is booking the same private office in Dublin but different date");
           //  bookingService.save(giovanniUsername, metaOfficeId, testDate.plusDays(14));
        } catch (BookingNotAvailableException e) {
            System.out.println(e.getMessage());
        }*/

        // Search by workstation type and building city
        WorkstationType searchType = WorkstationType.PRIVATE;
        String searchCity = "Dublin";

        List<Workstation> results = workstationService.findWorkstationsByTypeAndCity(searchType, searchCity);

        System.out.println("Found " + results.size() + " workstations of type " + searchType + " in " + searchCity + ":");
        results.forEach(ws -> System.out.println("- " + ws.getCode() + ": " + ws.getDescription()));
    }
}
