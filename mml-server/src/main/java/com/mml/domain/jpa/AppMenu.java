package com.mml.domain.jpa;

import javax.persistence.*;

/**
* app导航栏工具类
* @author liwenbing
* @create 2018/1/6/006 14:43
**/
@Entity
@Table(name = "t_app_menu")
public class AppMenu{
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String name;
    private String dex;
    private String icon;

    //没有默认构造会报错
    public AppMenu() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDex() {
        return dex;
    }

    public void setDex(String dex) {
        this.dex = dex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
