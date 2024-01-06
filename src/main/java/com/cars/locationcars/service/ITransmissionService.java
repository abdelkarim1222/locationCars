package com.cars.locationcars.service;

import com.cars.locationcars.entities.transmission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITransmissionService {
        public void saveTransmission(transmission a);
        public List<transmission> getAllTransmissions();
        public transmission getTransmissionBId(Long idTran);
        public void deleteTransmission(Long idTran);
        public Page<transmission> getTransmissionByMC(String mc, Pageable p);

}
