package ictech.u2_w1_d5_booking_management_project.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Record with id '" + id + "' not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
