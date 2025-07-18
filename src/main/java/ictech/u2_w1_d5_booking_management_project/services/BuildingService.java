package ictech.u2_w1_d5_booking_management_project.services;

import ictech.u2_w1_d5_booking_management_project.entities.Building;
import ictech.u2_w1_d5_booking_management_project.exceptions.NotFoundException;
import ictech.u2_w1_d5_booking_management_project.repositories.BuildingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    BuildingRepository buildingRepository;

    public void save(Building building) {
        buildingRepository.save(building);
        log.info("Building with name '" + building.getName() + "' and ID '" + building.getId() + "' was saved successfully!");
    }

    public Building findById(long id) {
        return buildingRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
