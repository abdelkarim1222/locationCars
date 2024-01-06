package com.cars.locationcars.service;

import com.cars.locationcars.dao.transmissionRepository;
import com.cars.locationcars.entities.transmission;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransmissionService implements ITransmissionService {
    private transmissionRepository transmissionRepository;
    @Override
    public void saveTransmission(transmission a) {
        transmissionRepository.save(a);
    }

    @Override
    public List<transmission> getAllTransmissions() {
        return transmissionRepository.findAll();
    }

    @Override
    public transmission getTransmissionBId(Long idTran) {
        return transmissionRepository.findById(idTran).orElse(null);
    }

    @Override
    public void deleteTransmission(Long idTran) {
        transmissionRepository.deleteById(idTran);
    }

    @Override
    public Page<transmission> getTransmissionByMC(String mc, Pageable p) {
        return transmissionRepository.findByLabelleContains(mc, p);
    }
}
