package com.monster.garage.entities.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

  @RequestMapping("/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }
}
