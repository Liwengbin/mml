package com.mml.service;

import com.mml.domain.TResponse;
import org.springframework.data.domain.Pageable;

public interface UserService {

    /**
     * 验证token
     * @param obj
     */
    public void verification(Object obj);

    public TResponse findById(Long id);

    public TResponse getLogging(String caller_method,Pageable pageable);
}
