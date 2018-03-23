package com.mml.domain.jpa;

import com.mml.utils.ObjectListType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_node_data")
@TypeDef(name = "ObjectListType", typeClass = ObjectListType.class)
public class NodeData {
    @Id
    @GeneratedValue
    @Column(length = 20)
    private Long id;

    @Column(length = 20)
    @Type(type = "ObjectListType")
    private List<Object> tableHeader;

    @Type(type = "ObjectListType")
    private List<Object> tableData;

    @Type(type = "ObjectListType")
    private List<Object> columnLimit;
    private Date updateTime;
    @OneToOne
    @JoinColumn(name="node_id")
    private Node node;

    public NodeData() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Object> getTableHeader() {
        return tableHeader;
    }

    public void setTableHeader(List<Object> tableHeader) {
        this.tableHeader = tableHeader;
    }

    public List<Object> getTableData() {
        return tableData;
    }

    public void setTableData(List<Object> tableData) {
        this.tableData = tableData;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public List<Object> getColumnLimit() {
        return columnLimit;
    }

    public void setColumnLimit(List<Object> columnLimit) {
        this.columnLimit = columnLimit;
    }
}
