package com.monster.garage.entities.job;

import com.monster.garage.entities.car.Car;
import com.monster.garage.entities.customer.Customer;
import com.monster.garage.entities.part.Part;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "job")
@SecondaryTables({
                         @SecondaryTable(name = "labour")
                 })
public class Job {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String description;
  @Column
  private String date;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Part> parts;

  @ManyToOne(cascade = CascadeType.ALL)
  private Car car;
  @ManyToOne(cascade = CascadeType.ALL)
  private Customer customer;
  //customer join
  /*
  @Column(name = "name", table = "customer")
  private String custName;
  @Column(name = "surname", table = "customer")
  private String custSurname;
  */
  //car join
  /*
  @Column(name = "reg", table = "car")
  private String reg;
  @Column(name = "make", table = "car")
  private String make;
  @Column(name = "model", table = "car")
  private String model;
  @Column(name = "year", table = "car")
  private int year;
  @Column(name = "mileage", table = "car")
  private int mileage;
  @Column(name = "color", table = "car")
  private String color;
  */
  //labour join

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "labourId", table = "labour")
  private Integer labourId;
  @Column(name = "repairTime", table = "labour")
  private int repairTime;
  @Column(name = "rate", table = "labour")
  private double rate;
  @Column(name = "total", table = "labour")
  private double total;
/*
  @Column
  private Integer customerId;
  @Column
  private Integer carId;
  */

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Integer getLabourId() {
    return labourId;
  }

  public void setLabourId(Integer labourId) {
    this.labourId = labourId;
  }

  public int getRepairTime() {
    return repairTime;
  }

  public void setRepairTime(int repairTime) {
    this.repairTime = repairTime;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public List<Part> getParts() {
    return parts;
  }

  public void setParts(List<Part> parts) {
    this.parts = parts;
  }


  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
