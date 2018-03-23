package com.mml.domain.jpa;

import javax.persistence.*;
@Entity
@Table(name = "t_node_state")
public class NodeState {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private Integer sequence;//排列序号
    private String instStatus;
    @OneToOne
    @JoinColumn(name="node_id")
    private Node node;
    @OneToOne
    @JoinColumn(name="experiment_id")
    private Experiment experiment;
    public NodeState() {
        super();
    }

    public NodeState(Integer sequence, String instStatus, Node node, Experiment experiment) {
        super();
        this.sequence = sequence;
        this.instStatus = instStatus;
        this.node = node;
        this.experiment = experiment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getInstStatus() {
        return instStatus;
    }

    public void setInstStatus(String instStatus) {
        this.instStatus = instStatus;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }
}
