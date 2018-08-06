package com.monster.garage.entities.mot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MotController {

  @RequestMapping("/mot")
  public String mot() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "mot";
  }

}
