package com.monster.garage.entities.part;

import com.monster.garage.entities.job.Job;

import javax.persistence.*;

@Entity
@Table(name = "part")
public class Part {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "quantity")
  private String quantity;

  @Column(name = "invoiceNumber")
  private String invoiceNumber;

  @Column(name = "price")
  private double price;

  @Column(name = "supplier")
  private String supplier;

  @Column(name = "brand")
  private String brand;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "JOBID", referencedColumnName = "ID")
  private Job job;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public String toString() {
    String part = "Invoice number: " + getInvoiceNumber()
            + "\n Name: " + getName()
            + "\n Brand: " + getBrand()
            + "\n Supplier: " + getSupplier()
            + "\n Unit Price: " + getPrice()
            + "\n Quantity: " + getQuantity();
    return part;
  }

}


