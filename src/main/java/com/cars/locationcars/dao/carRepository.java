package com.cars.locationcars.dao;

import com.cars.locationcars.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface carRepository extends JpaRepository<Car,Long> {
    public Page<Car> findByMarqueContains(String mc, Pageable p);

    @Query("Select p from Car p where p.transmission.id= :x")
    public List<Car> getCarsBYTran(@Param("x") Long idC);

}
