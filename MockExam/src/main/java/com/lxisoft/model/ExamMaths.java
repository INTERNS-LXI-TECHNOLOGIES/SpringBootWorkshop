package com.lxisoft.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "examMaths")
public class ExamMaths implements Serializable {

    // private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;

    @Column
    private String qn;
    @Column
    private String opt1;
    @Column
    private String opt2;
    @Column
    private String opt3;
    @Column
    private String opt4;
    @Column
    private int ans;
    @Transient
    private int selectedOption;



    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getQn() {
        return qn;
    }
    public String getOpt1() {
        return opt1;
    }
    public String getOpt2() {
        return opt2;
    }
    public String getOpt3() {
        return opt3;
    }
    public String getOpt4() {
        return opt4;
    }
    public int getAns() {
        return ans;
    }

    public void setQn(String qn) {
        this.qn = qn;
    }
    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }
    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }
    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }
    public void setAns(int ans) {
        this.ans = ans;
    }
    public void setSelectedOption(int selectedOption)
    {
        this.selectedOption = selectedOption;
    }
    public int getSelectedOption()
    {
        return selectedOption;
    }




}