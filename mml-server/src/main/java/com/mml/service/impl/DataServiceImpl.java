package com.mml.service.impl;

import com.mml.dao.DataDao;
import com.mml.domain.TResponse;
import com.mml.exceptions.DataException;
import com.mml.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDao dataDao;

    private static TResponse tResponse = new TResponse();
    @Override
    public TResponse findStudentData(String class_name, Pageable pageable) throws DataException{
        return tResponse.getTResponse("oxs-pai-data","zh_CN",dataDao.findByClassNameIn(class_name,pageable),true);
    }
}
