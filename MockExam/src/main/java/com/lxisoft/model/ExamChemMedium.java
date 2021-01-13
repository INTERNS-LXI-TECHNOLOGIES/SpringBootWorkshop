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
@Table(name = "examChemMedium")
public class ExamChemMedium implements Serializable {

    // private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;



    @Column
    private String qnm;
    @Column
    private String opt1m;
    @Column
    private String opt2m;
    @Column
    private String opt3m;
    @Column
    private String opt4m;
    @Column
    private int ansm;
    @Transient
    private int selectedOptionm;

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }


    public String getQnm() {
        return qnm;
    }
    public String getOpt1m() {
        return opt1m;
    }
    public String getOpt2m() {
        return opt2m;
    }
    public String getOpt3m() {
        return opt3m;
    }
    public String getOpt4m() {
        return opt4m;
    }
    public int getAnsm() {
        return ansm;
    }

    public void setQnm(String qnm) {
        this.qnm = qnm;
    }
    public void setOpt1m(String opt1m) {
        this.opt1m = opt1m;
    }
    public void setOpt2m(String opt2m) {
        this.opt2m = opt2m;
    }
    public void setOpt3m(String opt3m) {
        this.opt3m = opt3m;
    }
    public void setOpt4m(String opt4m) {
        this.opt4m= opt4m;
    }
    public void setAnsm(int ansm) {
        this.ansm = ansm;
    }
    public void setSelectedOptionm(int selectedOptionm)
    {
        this.selectedOptionm = selectedOptionm;
    }
    public int getSelectedOptionm()
    {
        return selectedOptionm;
    }




}
