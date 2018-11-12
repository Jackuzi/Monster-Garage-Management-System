package com.monster.garage.entities.customer;

import com.monster.garage.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
  private final
  CustomerRepository customerRepository;

  private Message message = new Message();

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

  @RequestMapping("/customers")
  public String customers() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "customers";
  }

  //edit customer data and return edit modal view
  @GetMapping("/carsAndCustomers/customer/edit/{id}")
  public String editForm(@PathVariable("id") Integer id, Model model) {
    Customer customer = customerRepository.getOne(id);
    model.addAttribute("customer", customer);
    return "fragments/editCustomerForm :: editCustomerForm";

  }

  //show customer to delete
  @GetMapping("/carsAndCustomers/customer/delete/{id}")
  public String deleteCustomerModal(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("customer", customerRepository.findById(id));
    return "fragments/deleteConfirmationCustomer :: deleteConfirmationCustomer";

  }


  //save edited customer
  @PostMapping("/carsAndCustomers/customer/edit/{id}")
  public String saveForm(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
    try {
      message.showSuccessMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      message.showFailMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";

    }
  }

  @PostMapping("/carsAndCustomers/customer/delete/{id}")
  public String deleteCar(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
    try {
      customerRepository.delete(customer);
      message.showSuccessMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";

    } catch (Exception e) {
      e.printStackTrace();
      message.showFailMessage(redirectAttributes);
      return "redirect:/carsAndCustomers/cars";
    }
  }
}
