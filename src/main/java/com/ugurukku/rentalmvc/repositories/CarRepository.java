package com.ugurukku.rentalmvc.repositories;

import com.ugurukku.rentalmvc.entities.Car;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findAllByCategory_Id(Integer categoryId);

}
