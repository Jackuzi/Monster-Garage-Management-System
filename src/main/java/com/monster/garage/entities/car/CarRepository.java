package com.monster.garage.entities.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
  //List<String> getCarByReg(String reg);
}
