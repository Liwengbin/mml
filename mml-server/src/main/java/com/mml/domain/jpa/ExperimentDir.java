package com.mml.domain.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_experiment_dir")
public class ExperimentDir extends Model{
    private Long parentId;//父目录
    public ExperimentDir() {
        super();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
