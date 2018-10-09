package com.monster.garage.entities.job;


import com.monster.garage.entities.part.Part;
import com.monster.garage.entities.part.PartRepository;
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
  @Autowired
  PartRepository partRepository;

  @GetMapping("/job/new")
  public String jobView(Model model) {
    Job job = new Job();
    job.addPart(new Part());
    model.addAttribute("job", job);
    return "newJob";
  }

  @GetMapping("/job/manage")
  public String jobManageView(Model model) {
    //model.addAttribute("job", new Job());
    model.addAttribute("jobs", jobRepository.findAll());
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "manageJobs";
  }

  @PostMapping("/job/new/add")
  public String jobAdd(@ModelAttribute Job job, RedirectAttributes redirectAttributes) {
    try {
      System.out.println(job.getParts());
      partRepository.saveAll(job.getParts());
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



