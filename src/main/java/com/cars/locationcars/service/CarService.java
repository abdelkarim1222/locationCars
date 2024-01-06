package com.cars.locationcars.service;

import com.cars.locationcars.dao.carRepository;
import com.cars.locationcars.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@AllArgsConstructor
@Service
public class CarService implements ICarsService{
    private carRepository carRepository;
    @Override
    public void saveCar(Car C) throws IOException {
        carRepository.save(C);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> getCarsByMc(String mc, Pageable p) {
        return carRepository.findByMarqueContains(mc, p);
    }

    @Override
    public List<Car> getCarsBTran(Long idTran) {
        return  carRepository.getCarsBYTran(idTran);
    }
    
    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }


}

