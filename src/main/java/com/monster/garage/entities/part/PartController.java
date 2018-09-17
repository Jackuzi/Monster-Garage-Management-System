package com.monster.garage.entities.part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PartController {

  @RequestMapping("/partsOrdered")
  public String partsOrdered() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "partsOrdered";
  }
}