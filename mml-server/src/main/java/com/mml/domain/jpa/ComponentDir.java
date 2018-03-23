package com.mml.domain.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
*  组件目录
* @author liwenbing
* @create 2018/1/12/012 19:18
**/
@Entity
@Table(name = "t_component_dir")
public class ComponentDir extends Model {
    private Long parentId;//父目录

    public ComponentDir() {
        super();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
