package com.monster.garage.entities.settings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingsController {

  @RequestMapping("/settings")
  public String partsOrdered() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "settings";
  }
}