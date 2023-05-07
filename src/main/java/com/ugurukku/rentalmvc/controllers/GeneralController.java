package com.ugurukku.rentalmvc.controllers;

import com.ugurukku.rentalmvc.dtos.CarRequest;
import com.ugurukku.rentalmvc.entities.Car;
import com.ugurukku.rentalmvc.entities.Category;
import com.ugurukku.rentalmvc.entities.User;
import com.ugurukku.rentalmvc.repositories.CarRepository;
import com.ugurukku.rentalmvc.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GeneralController {

    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;


    public GeneralController(CarRepository carRepository, CategoryRepository categoryRepository) {
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public ModelAndView retrieveHome(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> categories = categoryRepository.findAll();
        modelAndView.addObject("categories", categories);

        model.addAttribute("user", new User());
        model.addAttribute("carRequest", new CarRequest(null, 1, 1));
        return modelAndView;
    }

    @GetMapping("/contact")
    public String retrieveAbout() {
        return "contact";
    }

    @GetMapping("/cars")
    public ModelAndView retrieveCarsByCategoryId(@RequestParam(name = "category") int id) {

        List<Car> cars = carRepository.findAllByCategory_Id(id);
        ModelAndView modelAndView = new ModelAndView("cars");
        modelAndView.addObject("cars", cars);


        return modelAndView;
    }


}
