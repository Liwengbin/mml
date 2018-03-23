package com.mml.service;
import com.mml.domain.TResponse;

public interface ExperimentService {
    /**
     * 查询具体实验
     * @param id
     * @return
     */
    TResponse findById(Long id);

    /**
     * 返回一个目录下的文件和目录
     * @param parentId
     * @return
     */
    TResponse findExperiment(Long parentId);

    /**
     * 返回一个目录下的目录
     * @param parentId
     * @return
     */
    TResponse findExperimentDir(Long parentId);

    /**
     * 新建实验
     * @param name
     * @param projectName
     * @param description
     * @param parentId
     * @return
     */
    TResponse registerExperiment(String name,String projectName,String description,Long parentId);
}
