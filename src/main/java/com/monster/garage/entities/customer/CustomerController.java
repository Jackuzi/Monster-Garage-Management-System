package com.monster.garage.entities.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
  @Autowired
  CustomerRepository customerRepository;

  @RequestMapping("/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }

  //edit customer data and return edit modal view
  @GetMapping("/carsAndCustomers/cars/edit/customer/{id}")
  public String editForm(@PathVariable("id") Integer id, Model model) {
    Customer customer = customerRepository.getOne(id);
    model.addAttribute("customer", customer);
    return "fragments/editCustomerForm :: editCustomerView";

  }

  @PostMapping("/carsAndCustomers/cars/edit/customer/{id}")
  public String saveForm(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
    try {
      customerRepository.save(customer);
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
}
