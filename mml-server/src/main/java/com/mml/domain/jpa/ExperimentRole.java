package com.mml.domain.jpa;

import javax.persistence.*;
@Entity
@Table(name = "t_experiment_role")
public class ExperimentRole {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private Long roleID;//角色编号
    private String name;
    private boolean removeExperiment;//删除实验
    private boolean updateExperiment;//编辑实验
    private boolean memberRegister;//成员注册
    private boolean updateMemberRole;//修改成员角色
    private boolean removeMember;//删除成员
    private boolean runningExperiment;//运行实验
    private boolean checkExperimentRecord;//查看实验记录
    private boolean onlineExperiment;//上线实验
    private boolean offlineExperiment;//下线实验

    public ExperimentRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRemoveExperiment() {
        return removeExperiment;
    }

    public void setRemoveExperiment(boolean removeExperiment) {
        this.removeExperiment = removeExperiment;
    }

    public boolean isUpdateExperiment() {
        return updateExperiment;
    }

    public void setUpdateExperiment(boolean updateExperiment) {
        this.updateExperiment = updateExperiment;
    }

    public boolean isMemberRegister() {
        return memberRegister;
    }

    public void setMemberRegister(boolean memberRegister) {
        this.memberRegister = memberRegister;
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

    public boolean isRunningExperiment() {
        return runningExperiment;
    }

    public void setRunningExperiment(boolean runningExperiment) {
        this.runningExperiment = runningExperiment;
    }

    public boolean isCheckExperimentRecord() {
        return checkExperimentRecord;
    }

    public void setCheckExperimentRecord(boolean checkExperimentRecord) {
        this.checkExperimentRecord = checkExperimentRecord;
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
}
