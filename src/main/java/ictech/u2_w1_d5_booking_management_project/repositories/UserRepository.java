package ictech.u2_w1_d5_booking_management_project.repositories;

import ictech.u2_w1_d5_booking_management_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Derived query

    Optional<User> findByUsername(String Username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
