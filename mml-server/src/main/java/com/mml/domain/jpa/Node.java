package com.mml.domain.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_node")
public class Node {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String name;
    private String defName;//默认名
    private String cateGory;//类型
    private Integer positionX;
    private Integer positionY;
    private boolean isComposite;
    private Date startTime;
    private Date lastTime;
    private String icon;
    private Long experimentId;
    private Integer inNumber;
    private Integer outNumber;
    //指定一对多的关系 指明学生对象为关系的被维护端 使用grade对象中的student属性进行维护
    //并且级联所有的更新操作
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id")
    private List<NodeInPort> inPorts;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id")
    private List<NodeOutPort> outPorts;

    public Node() {
        super();
    }

    public String getCateGory() {
        return cateGory;
    }

    public void setCateGory(String cateGory) {
        this.cateGory = cateGory;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getDefName() {
        return defName;
    }

    public void setDefName(String defName) {
        this.defName = defName;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public boolean isComposite() {
        return isComposite;
    }

    public void setComposite(boolean composite) {
        isComposite = composite;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public List<NodeInPort> getInPorts() {
        return inPorts;
    }

    public void setInPorts(List<NodeInPort> inPorts) {
        this.inPorts = inPorts;
    }

    public List<NodeOutPort> getOutPorts() {
        return outPorts;
    }

    public void setOutPorts(List<NodeOutPort> outPorts) {
        this.outPorts = outPorts;
    }

    public Integer getInNumber() {
        return inNumber;
    }

    public void setInNumber(Integer inNumber) {
        this.inNumber = inNumber;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }
}
