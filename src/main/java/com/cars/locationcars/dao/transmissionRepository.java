package com.cars.locationcars.dao;

import com.cars.locationcars.entities.transmission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface transmissionRepository extends JpaRepository<transmission,Long> {
    public Page<transmission> findByLabelleContains(String mc, Pageable p);
    @Query("Select c from transmission c where c.id= :x")
    public List<transmission> getTransmissionBYtn(@Param("x") Long idC);
}
