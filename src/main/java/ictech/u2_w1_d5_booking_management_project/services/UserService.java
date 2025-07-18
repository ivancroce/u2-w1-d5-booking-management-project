package ictech.u2_w1_d5_booking_management_project.services;

import ictech.u2_w1_d5_booking_management_project.entities.User;
import ictech.u2_w1_d5_booking_management_project.exceptions.NotFoundException;
import ictech.u2_w1_d5_booking_management_project.exceptions.ValidationException;
import ictech.u2_w1_d5_booking_management_project.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ValidationException("Username '" + user.getUsername() + "' is already in use.");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email '" + user.getEmail() + "' is already in use.");
        }

        userRepository.save(user);
        log.info("User '" + user.getUsername() + "' was saved successfully!");
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username '" + username + "' not found!"));
    }
}
