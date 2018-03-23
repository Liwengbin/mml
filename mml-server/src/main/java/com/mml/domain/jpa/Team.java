package com.mml.domain.jpa;

import javax.persistence.*;
import java.util.Date;
/**
*  团队实体
* @author liwenbing
* @create 2018/1/6/006 23:13
**/
@Entity
@Table(name = "t_team")
public class Team {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String name;
    private Date createTime;
    private Date lastUpdateTime;

    public Team() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
