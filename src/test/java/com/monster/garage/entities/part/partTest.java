package com.monster.garage.entities.part;

import com.google.gson.Gson;
import com.monster.garage.entities.job.Job;
import com.monster.garage.entities.job.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class partTest {

  @Autowired
  private EntityManager em;

  @Autowired
  private PartRepository partRepository;

  @Autowired
  private JobRepository jobRepository;

  @Test
  public void partListAddingTest() {
    List<Part> parts = new ArrayList<>();
    Part part;
    Job job = new Job();
    job.setDescription("x");
    job.setDate(String.valueOf(new Date(Calendar.getInstance().getTime().getTime())));
    //labour
    job.setRepairTime(60);
    job.setRate(8.0D);
    job.setTotal(120.0D);
    job.setCar(null);
    job.setCustomer(null);
    //generating parts list
    for (int i = 0; i < 11; i++) {
      part = new Part();
      part.setName("x" + i);
      part.setQuantity("1" + i);
      part.setInvoiceNumber("123" + i);
      part.setPrice(1.0D + i);
      part.setSupplier("x" + i);
      part.setBrand("x" + i);
      parts.add(part);
    }
    // job.setParts(parts);
    em.persist(job);
    parts = partRepository.findAll();
    List<Job> jobs = jobRepository.findAll();
    Gson gson = new Gson();
    System.out.println(gson.toJson(jobs));
    System.out.println(gson.toJson(parts));
    em.flush();


  }
}
