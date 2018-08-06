package com.monster.garage.entities.dashboard;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dashboardController {

  @RequestMapping("/dashboard")
  public String dashboard() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "dashboard";
  }
}
