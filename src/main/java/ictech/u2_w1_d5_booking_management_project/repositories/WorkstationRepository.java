package ictech.u2_w1_d5_booking_management_project.repositories;

import ictech.u2_w1_d5_booking_management_project.entities.Workstation;
import ictech.u2_w1_d5_booking_management_project.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
    List<Workstation> findByTypeAndBuildingCity(WorkstationType type, String city);
}
