package com.monster.garage.entities.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
  @Autowired
  CarRepository repository;
  //private List<Car> cars = new ArrayList<>(asList(new Car()));

  public List<Car> getAllCars() {
    return repository.findAll();
  }

  public Car getCarByReg(String reg) {
    for (Car car : repository.findAll()) {
      if (car.getReg().equals(reg)) {
        return car;
      }
    }
    return null;
  }

  public void addCar(Car car) {
    repository.save(car);
  }

  public void updateCar(String id, Car car) {
    if (repository.existsById(Integer.valueOf(id))) {
      repository.save(car);
    }
  }


  public void deleteCar(String id) {
    repository.deleteById(Integer.valueOf(id));
  }
}
