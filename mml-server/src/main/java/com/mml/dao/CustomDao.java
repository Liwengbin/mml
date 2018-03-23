package com.mml.dao;
import java.util.List;
import java.util.Map;

public interface CustomDao {
    Map<String,Object> getNodeState(Long experimentId);
    List getLogging();
}
