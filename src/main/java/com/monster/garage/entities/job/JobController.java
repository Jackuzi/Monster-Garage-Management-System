package com.monster.garage.entities.job;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

  @RequestMapping("/job/new")
  public String jobView() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "newJob";
  }

  @RequestMapping("/job/manage")
  public String jobManageView() {
    //System.out.println("hello" + Arrays.asList(new CarService().getAllCars().get(1)));
    return "manageJobs";
  }
}



