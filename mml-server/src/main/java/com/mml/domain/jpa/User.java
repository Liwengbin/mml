package com.mml.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;
    private String userName;
    private String userPhone;
    private String userEmail;
    @OneToOne
    @JoinColumn(name="experiment_dir_id")
    private ExperimentDir experimentDir;
    @OneToOne
    @JoinColumn(name="last_operation_id")
    private LastOperation lastOperation;
    @OneToOne
    @JoinColumn(name="system_role_id")
    private SystemRole systemRole;

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ExperimentDir getExperimentDir() {
        return experimentDir;
    }

    public void setExperimentDir(ExperimentDir experimentDir) {
        this.experimentDir = experimentDir;
    }

    public LastOperation getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(LastOperation lastOperation) {
        this.lastOperation = lastOperation;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }
}