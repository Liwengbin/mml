package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_port")
public class Port {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String description;
    private String type;
    public Port() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
