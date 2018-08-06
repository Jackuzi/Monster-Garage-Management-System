package com.monster.garage.entities.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

  @RequestMapping("/carsAndCustomers/cars")
  public String cars() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "cars";
  }

  @RequestMapping("/carsAndCustomers/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }


}
