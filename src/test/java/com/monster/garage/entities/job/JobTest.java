package com.monster.garage.entities.job;

import com.google.gson.Gson;
import com.monster.garage.entities.car.Car;
import com.monster.garage.entities.customer.Customer;
import com.monster.garage.entities.mot.Mot;
import com.monster.garage.entities.part.Part;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JobTest {
  @Autowired
  private EntityManager em;

  @Autowired
  private JobRepository jobRepository;

  @Test
  public void TestNewJobAdding() {
    Job job = new Job();
    Car car = new Car();
    Part part = new Part();
    Customer customer = new Customer();
    car.setReg("x");
    car.setMake("x");
    car.setModel("x");
    car.setYear(1);
    car.setMileage(1);
    car.setColor("x");
    //car.setMotId();
    Mot mot = new Mot();
    mot.setDateDone(new Date(new java.util.Date().getTime()));
    car.setMot(mot);
    //part.setId(0);
    part.setName("x");
    part.setQuantity("1");
    part.setInvoiceNumber("123");
    part.setPrice(1.0D);
    part.setSupplier("x");
    part.setBrand("x");
    //customer.setId(0);
    customer.setName("xxx");
    customer.setSurname("xxx");
    //job.setId(0);
    job.setDescription("x");
    job.setDate(String.valueOf(new Date(Calendar.getInstance().getTime().getTime())));
    // job.setLabourId(0);
    job.setRepairTime(60);
    job.setRate(8.0D);
    job.setTotal(120.0D);
    job.setCar(car);
    job.setCustomer(customer);
    //job.setParts(Lists.newArrayList(part));
    em.persist(car);
    em.persist(customer);
    em.persist(part);
    em.persist(job);
    List<Job> jobs = jobRepository.findAll();
    Gson gson = new Gson();
    System.out.println(gson.toJson(jobs));
    em.flush();

  }
}
