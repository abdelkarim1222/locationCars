package com.cars.locationcars.service;

import com.cars.locationcars.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICarsService {

    public void saveCar(Car p) throws IOException;
    public List<Car> getAllCars();
    public Page<Car> getCarsByMc(String mc, Pageable p);
    public List<Car> getCarsBTran(Long idTran);

    public void deleteCar(Long id);
    public Car getCarById(Long id);


}
