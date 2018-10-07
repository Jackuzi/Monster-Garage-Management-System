package com.monster.garage.entities.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JobController {
  @Autowired
  JobRepository jobRepository;

  @GetMapping("/job/new")
  public String jobView(Model model) {
    model.addAttribute("job", new Job());
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "newJob";
  }

  @GetMapping("/job/manage")
  public String jobManageView() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "manageJobs";
  }

  @PostMapping("/job/new/add")
  public String jobAdd(@ModelAttribute Job job, RedirectAttributes redirectAttributes) {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    try {
      jobRepository.save(job);
      redirectAttributes.addFlashAttribute("message", "Success. Record updated");
      redirectAttributes.addFlashAttribute("alertClass", "alert-success");
      return "redirect:/job/new";
    } catch (Exception e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message", "Failed. Please check the data");
      redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
      return "redirect:/job/new";
    }

  }

}



