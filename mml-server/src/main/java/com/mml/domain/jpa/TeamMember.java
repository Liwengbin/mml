package com.mml.domain.jpa;

import javax.persistence.*;

/**
*  团队与成员的关系实体
* @author liwenbing
* @create 2018/1/6/006 23:13
**/
@Entity
@Table(name = "t_team_member")
public class TeamMember {
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
    @JoinColumn(name="team_role_id")
    private TeamRole teamRole;

    public TeamMember() {
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

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }
}
