package com.mml.domain.jpa;

import javax.persistence.*;
@Entity
@Table(name = "t_experiment_member")
public class ExperimentMember {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    @OneToOne
    @JoinColumn(name="team_id")
    private Team team;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JoinColumn(name="experiment_role_id")
    ExperimentRole experimentRole;

    public ExperimentMember() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExperimentRole getExperimentRole() {
        return experimentRole;
    }

    public void setExperimentRole(ExperimentRole experimentRole) {
        this.experimentRole = experimentRole;
    }
}
