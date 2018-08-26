package com.monster.garage.entities.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

  @Autowired
  CarRepository carRepository;

  @RequestMapping("/carsAndCustomers/cars")
  public String cars(Model model) {
    model.addAttribute("cars", carRepository.findAll());
    return "cars";
  }

  @RequestMapping("/carsAndCustomers/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }

  /*@PostMapping(value = "/carsAndCustomers/cars", params = "action=edit")
  public ModelAndView edit(@RequestParam String id) {
    System.out.println(carRepository.getOne(Integer.valueOf(id)));
    ModelAndView mav = new ModelAndView();
    mav.addObject("message", id);
    //mav.setViewName("show");
    return mav;

  }*/

  @RequestMapping("/carsAndCustomers/cars/{id}")
  public String view(@PathVariable("id") Integer id, ModelMap modelMap) {
    Car car = carRepository.getOne(id);
    modelMap.addAttribute("car", car);
    return "fragments/editForm :: editView";

  }


}
