package com.monster.garage.entities.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

  @Autowired
  private CarService carService;

  @RequestMapping("/cars")
  public List<Car> car() {
    return carService.getAllCars();
  }


  @GetMapping("/cars/{reg}")
  public Car getCarByReg(@PathVariable String reg) {
    return carService.getCarByReg(reg);
  }

  @PostMapping(value = "/cars")
  public void addCar(@RequestBody Car car) {
    carService.addCar(car);
  }

  @PutMapping(value = "/cars/{id}")
  public void updateCar(@PathVariable String id, @RequestBody Car car) {
    carService.updateCar(id, car);
  }

  @DeleteMapping(value = "/cars/{id}")
  public void deleteCar(@PathVariable String id) {
    carService.deleteCar(id);
  }

}
