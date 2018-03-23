package com.mml.domain.jpa;

import javax.persistence.*;


@Entity
@Table(name = "t_student_data")
public class StudentData {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String className;
    private Integer sex;
    private double yuwen;
    private double yingyu;
    private double shuxue;
    private double wuli;
    private double huaxue;
    private double shengwu;

    public StudentData() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public double getYuwen() {
        return yuwen;
    }

    public void setYuwen(double yuwen) {
        this.yuwen = yuwen;
    }

    public double getYingyu() {
        return yingyu;
    }

    public void setYingyu(double yingyu) {
        this.yingyu = yingyu;
    }

    public double getShuxue() {
        return shuxue;
    }

    public void setShuxue(double shuxue) {
        this.shuxue = shuxue;
    }

    public double getWuli() {
        return wuli;
    }

    public void setWuli(double wuli) {
        this.wuli = wuli;
    }

    public double getHuaxue() {
        return huaxue;
    }

    public void setHuaxue(double huaxue) {
        this.huaxue = huaxue;
    }

    public double getShengwu() {
        return shengwu;
    }

    public void setShengwu(double shengwu) {
        this.shengwu = shengwu;
    }
}
