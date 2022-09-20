package com.lxisoft.vegetablestore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

  public Category(String type) {
    this.type = type;
  }

  public Category() {}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "types")
  private String type;

  @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "cate_Id",referencedColumnName = "id")
  List<Vegetable> vegetables = new ArrayList<>();


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Vegetable> getVegetables() {
    return vegetables;
  }

  public void setVegetables(List<Vegetable> vegetables) {
    this.vegetables = vegetables;
  }


}
