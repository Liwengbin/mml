package com.mml.domain.jpa;

import javax.persistence.*;

/**
*  实体模型
* @author liwenbing
* @create 2018/1/12/012 11:52
**/
@MappedSuperclass
public abstract class Model {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;//分组唯一id
    @Column(length = 225,nullable = false)
    private String name;//名
    private String description;//描述
    private boolean isEnabled;//是否可用
    private int sequence;//排列序号
    private String icon;//图类型
    private boolean isDir;//是否为目录

    public Model() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }
}
