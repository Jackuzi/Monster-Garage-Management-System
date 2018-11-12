package com.monster.garage.entities.car;

import com.monster.garage.entities.customer.Customer;
import com.monster.garage.entities.customer.CustomerRepository;
import com.monster.garage.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarController {

  private final
  CarRepository carRepository;
  private final
  CustomerRepository customerRepository;
  private Message message = new Message();

  @Autowired
  public CarController(CarRepository carRepository, CustomerRepository customerRepository) {
    this.carRepository = carRepository;
    this.customerRepository = customerRepository;
  }

  @RequestMapping("/carsAndCustomers/cars")
  public String cars(Model model) {
    model.addAttribute("cars", carRepository.findAll());
    model.addAttribute("car", new Car());
    model.addAttribute("customers", customerRepository.findAll());
    model.addAttribute("customer", new Customer());
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
      message.showSuccessMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      message.showFailMessage(redirectAttributes);
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
      message.showSuccessMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      message.showFailMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";
    }
  }
}
