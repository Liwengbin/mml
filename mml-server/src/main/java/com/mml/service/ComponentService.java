package com.mml.service;

import com.mml.domain.TResponse;

public interface ComponentService {
    /**
     * 查询具体组件
     * @param id
     * @return
     */
    TResponse findById(Long id);

    /**
     * 返回一个目录下的文件和目录
     * @param parentId
     * @return
     */
    TResponse findComponent(Long parentId);
}
