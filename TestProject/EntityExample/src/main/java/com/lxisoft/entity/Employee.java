package com.lxisoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author imssbora
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="EMP_ID")
   private long id;
   
   @Column(name="NAME",nullable=false)
   private String name;
   
   @Column(name="DESIGNATION")
   private String designation;
   
   @ManyToOne
   @JoinColumn(name="DPT_ID",foreignKey=@ForeignKey(name="DPT_ID_FK"))
   private String department;

   public long getId() {
       return id;
   }

   public void setId(long id) {
       this.id = id;
   }
   
   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
   
   public String getDesignation() {
       return designation;
   }

   public void setDesignation(String designation) {
       this.designation = designation;
   }
   
   public String getDepartment() {
       return department;
   }

   public void setDepartment(String department) {
       this.department = department;
   }
}