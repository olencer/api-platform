package com.api.service;

import com.api.service.impl.UserInterfaceInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInterfaceInfoServiceTest {

    @Resource
    private UserInterfaceInfoServiceImpl userInterfaceInfoServiceImpl;

    @Test
    void invokeCount() {
        boolean b = userInterfaceInfoServiceImpl.invokeCount(1, 1);
        Assertions.assertTrue(b);
    }
}