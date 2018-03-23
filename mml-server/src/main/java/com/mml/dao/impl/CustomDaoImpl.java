package com.mml.dao.impl;

import com.mml.dao.CustomDao;
import com.mml.domain.jpa.NodeState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CustomDaoImpl implements CustomDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Map<String,Object> getNodeState(Long experimentId) {
        String sql = "select t.node_id, t.inst_status from t_node_state t where t.experiment_id = ?1";
        TypedQuery query = (TypedQuery) entityManager.createNativeQuery(sql);
        query.setParameter(1, experimentId);

        List<?> value= query.getResultList();
        Map<String,Object> map = new HashMap<String,Object>();
        for(int i=0;i<value.size();i++) {
            map.put(String.valueOf(((Object[])value.get(i))[0]),((Object[])value.get(i))[1]);
        }
        return map;
    }

    @Override
    public List getLogging() {
        String sql = "select * from logging_event t order by t.event_id desc limit 0,5";
        TypedQuery query = (TypedQuery) entityManager.createNativeQuery(sql);
        List<?> value= query.getResultList();

        return value;
    }

}
