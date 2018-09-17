package com.monster.garage.entities.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private TestEntityManager em;

  @Test
  public void carRepositoryTest() {
    Car car = new Car();
    //car.setId(0);
    car.setReg("AAA123");
    car.setMake("AAAA");
    car.setModel("AAAA");
    car.setYear(1991);
    car.setMileage(2000);
    car.setColor("Yellow");
    em.persist(car);
    em.flush();
    List<Car> cars = carRepository.findAll();
    assertEquals(1, cars.size());

  }

}
