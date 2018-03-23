package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_component_port")
public class ComponentPort {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    @OneToOne
    @JoinColumn(name="port_id")
    private Port port;
    private String type;
    private Integer sequence;//排列序号

    public ComponentPort() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
