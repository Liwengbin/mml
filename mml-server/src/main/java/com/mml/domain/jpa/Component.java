package com.mml.domain.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
* 实验组件
* @author liwenbing
* @create 2017/12/25/025 15:18
**/
@Entity
@Table(name = "t_component")
public class Component extends Model {
    private String author;//创建者
    private Date createdTime;
    private String docUrl;
    private String iconType;//图类型
    private String defSource;//数据源类型
    private String owner;//拥有者
    private Date lastModifyTime;//最后一次的修改时间
    private String category;//类型
    private String ioType;
    private Long parentId;//父目录
    private Integer inNumber;
    private Integer outNumber;
    //指定一对多的关系 指明学生对象为关系的被维护端 使用grade对象中的student属性进行维护
    //并且级联所有的更新操作
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private List<ComponentPort> Ports;

    public Component() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getDefSource() {
        return defSource;
    }

    public void setDefSource(String defSource) {
        this.defSource = defSource;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIoType() {
        return ioType;
    }

    public void setIoType(String ioType) {
        this.ioType = ioType;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public List<ComponentPort> getPorts() {
        return Ports;
    }

    public void setPorts(List<ComponentPort> ports) {
        Ports = ports;
    }
}
