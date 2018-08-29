package com.monster.garage.entities.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

  @Autowired
  CarRepository carRepository;

  @RequestMapping("/carsAndCustomers/cars")
  public String cars(Model model) {
    model.addAttribute("cars", carRepository.findAll());
    model.addAttribute("car", new Car());
    return "cars";
  }

  @RequestMapping("/carsAndCustomers/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }

  @GetMapping("/carsAndCustomers/cars/edit/{id}")
  public String editForm(@PathVariable("id") Integer id, Model model) {
    Car car = carRepository.getOne(id);
    model.addAttribute("car", car);
    return "fragments/editForm :: editView";

  }

  @PostMapping("/carsAndCustomers/cars/edit/{id}")
  public String saveForm(@ModelAttribute Car car) {
    carRepository.save(car);
    return "redirect:/carsAndCustomers/cars";

  }
}
