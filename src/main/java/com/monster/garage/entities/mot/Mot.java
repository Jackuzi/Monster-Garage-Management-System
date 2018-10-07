package com.monster.garage.entities.mot;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mot")
public class Mot {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private Date dateDone;

  public Mot() {
    super();
  }


  public Date getDateDone() {
    return dateDone;
  }

  public void setDateDone(Date dateDone) {
    this.dateDone = dateDone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
