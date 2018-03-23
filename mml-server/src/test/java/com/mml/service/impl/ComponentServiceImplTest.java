package com.mml.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentServiceImplTest {
    @Autowired
    private ComponentServiceImpl componentService;
    @Test
    public void findById() throws Exception {
        componentService.findById(Long.valueOf(1));
    }

    @Test
    public void findComponent() throws Exception {
        componentService.findComponent(Long.valueOf("10000"));
    }

}