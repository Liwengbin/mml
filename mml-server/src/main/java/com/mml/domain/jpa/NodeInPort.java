package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_node_in_port")
public class NodeInPort {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    @OneToOne
    @JoinColumn(name="port_id")
    private Port port;
    private Integer sequence;//排列序号

    public NodeInPort() {
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
}
