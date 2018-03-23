package com.mml.domain.jpa;

import javax.persistence.*;
@Entity
@Table(name = "t_team_role")
public class TeamRole {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String name;
    private boolean checkTeamInformation;//查看团队统计信息
    private boolean updateTeamInformation; //修改团信息
    private boolean addMembers;//添加成员
    private boolean updateMemberRole;//修改成员角色
    private boolean removeMember;//删除成员
    private boolean removeTeam;//删除团队
    private boolean onlineExperiment;//上线实验
    private boolean offlineExperiment;//下线实验
    private boolean removeExperiment;//删除实验
    private boolean memberRegister;//成员注册

    public TeamRole() {
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

    public boolean isCheckTeamInformation() {
        return checkTeamInformation;
    }

    public void setCheckTeamInformation(boolean checkTeamInformation) {
        this.checkTeamInformation = checkTeamInformation;
    }

    public boolean isUpdateTeamInformation() {
        return updateTeamInformation;
    }

    public void setUpdateTeamInformation(boolean updateTeamInformation) {
        this.updateTeamInformation = updateTeamInformation;
    }

    public boolean isAddMembers() {
        return addMembers;
    }

    public void setAddMembers(boolean addMembers) {
        this.addMembers = addMembers;
    }

    public boolean isUpdateMemberRole() {
        return updateMemberRole;
    }

    public void setUpdateMemberRole(boolean updateMemberRole) {
        this.updateMemberRole = updateMemberRole;
    }

    public boolean isRemoveMember() {
        return removeMember;
    }

    public void setRemoveMember(boolean removeMember) {
        this.removeMember = removeMember;
    }

    public boolean isRemoveTeam() {
        return removeTeam;
    }

    public void setRemoveTeam(boolean removeTeam) {
        this.removeTeam = removeTeam;
    }

    public boolean isOnlineExperiment() {
        return onlineExperiment;
    }

    public void setOnlineExperiment(boolean onlineExperiment) {
        this.onlineExperiment = onlineExperiment;
    }

    public boolean isOfflineExperiment() {
        return offlineExperiment;
    }

    public void setOfflineExperiment(boolean offlineExperiment) {
        this.offlineExperiment = offlineExperiment;
    }

    public boolean isRemoveExperiment() {
        return removeExperiment;
    }

    public void setRemoveExperiment(boolean removeExperiment) {
        this.removeExperiment = removeExperiment;
    }

    public boolean isMemberRegister() {
        return memberRegister;
    }

    public void setMemberRegister(boolean memberRegister) {
        this.memberRegister = memberRegister;
    }

}
