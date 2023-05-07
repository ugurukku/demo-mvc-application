package com.ugurukku.rentalmvc.controllers;

import com.ugurukku.rentalmvc.dtos.CarRequest;
import com.ugurukku.rentalmvc.entities.Car;
import com.ugurukku.rentalmvc.entities.Category;
import com.ugurukku.rentalmvc.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public String addCar(@ModelAttribute CarRequest request){
        carRepository
                .save(new Car(null,
                        request.name(),
                        request.productionYear(),
                        new Category(request.categoryId(), null)));
        return "index";
    }

}
