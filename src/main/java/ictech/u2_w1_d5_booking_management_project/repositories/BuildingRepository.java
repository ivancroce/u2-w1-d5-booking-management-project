package ictech.u2_w1_d5_booking_management_project.repositories;

import ictech.u2_w1_d5_booking_management_project.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
