package com.carRental.java.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Integer carId) {
        boolean exists = carRepository.existsById(carId);
        if (!exists) {
            throw new IllegalStateException(
                    "Car with id " + carId + " does not exists!");
        }
        carRepository.deleteById(carId);
    }

    public Car getCarById(Integer id) {
        Optional<Car> optional = carRepository.findCarById(id);
        Car car = null;

        if (optional.isPresent()) {
            car = optional.get();
        } else {
            throw new RuntimeException("Car not found for id :: " + id);
        }
        return car;
    }


    public void deleteCarById(Integer id) {
        this.carRepository.deleteById(id);
    }
}
