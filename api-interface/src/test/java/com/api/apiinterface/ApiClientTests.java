package com.api.apiinterface;

import com.api.apiclientsdk.client.ApiClient;
import com.api.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class ApiClientTests {
    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        String res1 = apiClient.getNameByGet("api1");
        String res2 = apiClient.getNameByPost("api2");

        User user = new User();
        user.setUsername("api3");
        String res3 = apiClient.getUsernameByPost(user);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
