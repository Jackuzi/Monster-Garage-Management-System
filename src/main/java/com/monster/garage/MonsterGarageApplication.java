package com.monster.garage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonsterGarageApplication implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());


  public static void main(String[] args) {
    SpringApplication.run(MonsterGarageApplication.class, args);


  }

  @Override
  public void run(String... args) throws Exception {
    //logger.info("Student id 1 -> {}", repository.findById(1));
    //logger.info("All cars 1 -> {}", repository.findAll());
    //Insert
    //logger.info("Inserting -> {}", repository.save(new Car(3, "EX65TAP", "Kia", "i40", 2018, 125000, "Grey")));
    //Update
    //logger.info("Update 10001 -> {}", repository.save(new Car(1, "EX65ABC", "Mercedes", "E220", 2018, 125000, "Blue")));
    //repository.deleteById(3);
    //logger.info("All users 2 -> {}", repository.findAll());
    //List<String> cars =  repository.
  }


}
