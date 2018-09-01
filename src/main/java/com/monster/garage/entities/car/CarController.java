package com.monster.garage.entities.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  public String saveForm(@ModelAttribute Car car, RedirectAttributes redirectAttributes) {
    try {
      carRepository.save(car);
      redirectAttributes.addFlashAttribute("message", "Success. Record updated");
      redirectAttributes.addFlashAttribute("alertClass", "alert-success");
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message", "Failed. Please check the data");
      redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
      return "redirect:/carsAndCustomers/cars";

    }
  }

  @GetMapping("/carsAndCustomers/cars/new")
  public String newCar(Model model) {
    model.addAttribute("car", new Car());
    return "fragments/editForm :: editView";

  }

  @GetMapping("/carsAndCustomers/cars/delete/{id}")
  public String deleteCarModal(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("car", carRepository.findById(id));
    return "fragments/deleteConfirmation :: deleteConfirmation";

  }

  @PostMapping("/carsAndCustomers/cars/delete/{id}")
  public String deleteCar(@ModelAttribute Car car, RedirectAttributes redirectAttributes) {
    try {
      carRepository.delete(car);
      redirectAttributes.addFlashAttribute("message", "Success. Record Removed");
      redirectAttributes.addFlashAttribute("alertClass", "alert-success");
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message", "An error occurred");
      redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
      return "redirect:/carsAndCustomers/cars";
    }
  }
}
