package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_system_role")
public class SystemRole {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String name;//角色名称
    private boolean checkTeam;//查看团队
    private boolean createTeam;//创建团队
    private boolean checkExperiment;//查看所有实验
    private boolean createExperimentTemplate;//新建(模板)实验
    private boolean adminRegister;//管理员注册
    private boolean checkSystemUser;//查看系统用户
    private boolean updateUserSystemRoles;//修改用户系统角色
    private boolean updateInformation;//修改个人信息
    private boolean checkAgent;//查看Agent列表 （代理）
    private boolean updateAgent;//修改Agent信息

    public SystemRole() {
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

    public boolean isCheckTeam() {
        return checkTeam;
    }

    public void setCheckTeam(boolean checkTeam) {
        this.checkTeam = checkTeam;
    }

    public boolean isCreateTeam() {
        return createTeam;
    }

    public void setCreateTeam(boolean createTeam) {
        this.createTeam = createTeam;
    }

    public boolean isCheckExperiment() {
        return checkExperiment;
    }

    public void setCheckExperiment(boolean checkExperiment) {
        this.checkExperiment = checkExperiment;
    }

    public boolean isCreateExperimentTemplate() {
        return createExperimentTemplate;
    }

    public void setCreateExperimentTemplate(boolean createExperimentTemplate) {
        this.createExperimentTemplate = createExperimentTemplate;
    }

    public boolean isAdminRegister() {
        return adminRegister;
    }

    public void setAdminRegister(boolean adminRegister) {
        this.adminRegister = adminRegister;
    }

    public boolean isCheckSystemUser() {
        return checkSystemUser;
    }

    public void setCheckSystemUser(boolean checkSystemUser) {
        this.checkSystemUser = checkSystemUser;
    }

    public boolean isUpdateUserSystemRoles() {
        return updateUserSystemRoles;
    }

    public void setUpdateUserSystemRoles(boolean updateUserSystemRoles) {
        this.updateUserSystemRoles = updateUserSystemRoles;
    }

    public boolean isUpdateInformation() {
        return updateInformation;
    }

    public void setUpdateInformation(boolean updateInformation) {
        this.updateInformation = updateInformation;
    }

    public boolean isCheckAgent() {
        return checkAgent;
    }

    public void setCheckAgent(boolean checkAgent) {
        this.checkAgent = checkAgent;
    }

    public boolean isUpdateAgent() {
        return updateAgent;
    }

    public void setUpdateAgent(boolean updateAgent) {
        this.updateAgent = updateAgent;
    }
}
