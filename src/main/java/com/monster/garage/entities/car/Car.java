package com.monster.garage.entities.car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "car")
@SecondaryTables({
                         @SecondaryTable(name = "mot"),

                 })
public class Car {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  @NotNull
  private String reg;
  @NotNull
  @Column
  private String make;
  @Column
  @NotNull
  private String model;
  @Column
  private int year;
  @Column
  private int mileage;
  @Column
  private String color;

  //MOT Table
  @Column(name = "dateDone", table = "mot")
  private Date dateDone;


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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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


  public Date getDateDone() {
    return dateDone;
  }

  public void setDateDone(Date dateDone) {
    this.dateDone = dateDone;
  }
}
