package com.mml.domain.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
*  实验实体类
* @author liwenbing
* @create 2018/1/12/012 11:24
**/
@Entity
@Table(name = "t_experiment")
public class Experiment extends Model{
    private String projectName;//项目名称
    private Date createdTime;
    private Date lastUpdateTime;
    private boolean isDeleted;
    private Long parentId;//父目录

    public Experiment() {
        super();
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
