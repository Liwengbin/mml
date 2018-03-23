package com.mml.domain;

import java.util.List;

public class TableData {
    private List<Object> tableHeader;
    private List<Object> tableContext;

    public TableData() {
        super();
    }

    public List<Object> getTableHeader() {
        return tableHeader;
    }

    public void setTableHeader(List<Object> tableHeader) {
        this.tableHeader = tableHeader;
    }

    public List<Object> getTableContext() {
        return tableContext;
    }

    public void setTableContext(List<Object> tableContext) {
        this.tableContext = tableContext;
    }
}
