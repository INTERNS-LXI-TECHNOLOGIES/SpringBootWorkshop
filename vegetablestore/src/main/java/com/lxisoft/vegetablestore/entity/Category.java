package com.lxisoft.vegetablestore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

  public Category(String category) {
    this.category = category;
  }

  public Category() {}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "category")
  private String category;

  @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
  List<Vegetable> vegetables = new ArrayList<>();


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<Vegetable> getVegetables() {
    return vegetables;
  }

  public void setVegetables(List<Vegetable> vegetables) {
    this.vegetables = vegetables;
  }


}
