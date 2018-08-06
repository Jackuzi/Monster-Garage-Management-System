package com.monster.garage.entities.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @Column
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String reg;
  @Column
  private String make;
  @Column
  private String model;
  @Column
  private int year;
  @Column
  private int mileage;
  @Column
  private String color;

  public Car() {
    super();
  }

  public Car(String reg, String make, String model, int year, int mileage, String color) {
    super();
    this.reg = reg;
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.color = color;
  }

  public Car(int id) {
    this.id = id;

  }

  public Car(Integer id, String reg, String make, String model, int year, int mileage, String color) {
    super();
    this.id = id;
    this.reg = reg;
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
