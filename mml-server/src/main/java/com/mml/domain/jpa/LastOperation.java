package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_last_operation")
public class LastOperation {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private Long last_experiment_id;//最后一次打开过的实验
    private String lastLanguage;
    private String theme;//最后一次更改过的主题

    public LastOperation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLast_experiment_id() {
        return last_experiment_id;
    }

    public void setLast_experiment_id(Long last_experiment_id) {
        this.last_experiment_id = last_experiment_id;
    }

    public String getLastLanguage() {
        return lastLanguage;
    }

    public void setLastLanguage(String lastLanguage) {
        this.lastLanguage = lastLanguage;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
