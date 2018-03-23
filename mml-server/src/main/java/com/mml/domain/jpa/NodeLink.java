package com.mml.domain.jpa;

import javax.persistence.*;

/**
*  节点之间的关联关系
* @author liwenbing
* @create 2018/1/6/006 23:14
**/
@Entity
@Table(name = "t_node_link")
public class NodeLink {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private Long source;//算法节点id
    private Long outputPortId;//输出节点id
    private Long target;//被算法节点id
    private Long inputPortId;//输入节点id
    private String type;
    private Long experimentId;//实验id

    public NodeLink(Long source, Long outputPortId, Long target, Long inputPortId, String type, Long experimentId) {
       super();
        this.source = source;
        this.outputPortId = outputPortId;
        this.target = target;
        this.inputPortId = inputPortId;
        this.type = type;
        this.experimentId = experimentId;
    }

    public NodeLink() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Long getOutputPortId() {
        return outputPortId;
    }

    public void setOutputPortId(Long outputPortId) {
        this.outputPortId = outputPortId;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public Long getInputPortId() {
        return inputPortId;
    }

    public void setInputPortId(Long inputPortId) {
        this.inputPortId = inputPortId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }
}
