package com.mml.domain;

import java.util.List;

public class Dir {
    private Long value;
    private String label;
    private List<Dir> children;

    public Dir() {
        super();
    }

    public Dir(Long value, String label, List<Dir> children) {
        this.value = value;
        this.label = label;
        this.children = children;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Dir> getChildren() {
        return children;
    }

    public void setChildren(List<Dir> children) {
        this.children = children;
    }
}
