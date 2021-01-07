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
@Table(name = "examHard")
public class ExamHard implements Serializable {

    // private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;



    @Column
    private String qnh;
    @Column
    private String opt1h;
    @Column
    private String opt2h;
    @Column
    private String opt3h;
    @Column
    private String opt4h;
    @Column
    private int ansh;
    @Transient
    private int selectedOptionh;

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getQnh() {
        return qnh;
    }
    public String getOpt1h() {
        return opt1h;
    }
    public String getOpt2h() {
        return opt2h;
    }
    public String getOpt3h() {
        return opt3h;
    }
    public String getOpt4h() {
        return opt4h;
    }
    public int getAnsh() {
        return ansh;
    }

    public void setQnh(String qnh) {
        this.qnh = qnh;
    }
    public void setOpt1h(String opt1h) {
        this.opt1h = opt1h;
    }
    public void setOpt2h(String opt2h) {
        this.opt2h = opt2h;
    }
    public void setOpt3h(String opt3h) {
        this.opt3h = opt3h;
    }
    public void setOpt4h(String opt4h) {
        this.opt4h= opt4h;
    }
    public void setAnsh(int ansh) {
        this.ansh = ansh;
    }
    public void setSelectedOptionh(int selectedOptionh)
    {
        this.selectedOptionh = selectedOptionh;
    }
    public int getSelectedOptionh()
    {
        return selectedOptionh;
    }




}
