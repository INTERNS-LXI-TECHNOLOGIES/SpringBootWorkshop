package com.lxisoft.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "attendedExam")
public class attendedExam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;

    @Column
    private String userName;

    @Column
    private String subName;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getNo() {
        return slno;
    }

    public void setNo(int slno) {
        this.slno = slno;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
