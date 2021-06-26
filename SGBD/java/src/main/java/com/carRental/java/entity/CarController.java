package com.carRental.java.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    String displayCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "index";
    }

    @PostMapping("/saveCar")
    public String registerNewCar(@ModelAttribute("car") Car car) {
        carService.addNewCar(car);
        return "redirect:/";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") Integer id) {
        this.carService.deleteCar(id);
        return "redirect:/";
    }


    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") Integer id, Model model) {

        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "update_car";
    }

    @GetMapping("/showNewCarForm")
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }
}
