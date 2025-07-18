package ictech.u2_w1_d5_booking_management_project.services;

import ictech.u2_w1_d5_booking_management_project.entities.Workstation;
import ictech.u2_w1_d5_booking_management_project.enums.WorkstationType;
import ictech.u2_w1_d5_booking_management_project.exceptions.NotFoundException;
import ictech.u2_w1_d5_booking_management_project.repositories.WorkstationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    WorkstationRepository workstationRepository;

    public void save(Workstation workstation) {
        workstationRepository.save(workstation);
        log.info("Workstation with ID '" + workstation.getId() + "' was saved successfully!");
    }

    public Workstation findById(long id) {
        return workstationRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Workstation> findWorkstationsByTypeAndCity(WorkstationType type, String city) {
        System.out.println("Searching for workstations of type " + type + " in " + city + "...");
        return workstationRepository.findByTypeAndBuildingCity(type, city);
    }
}
