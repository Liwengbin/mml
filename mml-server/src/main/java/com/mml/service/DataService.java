package com.mml.service;

import com.mml.domain.TResponse;
import org.springframework.data.domain.Pageable;

public interface DataService {
    TResponse findStudentData(String class_name, Pageable pageable);
}
