package com.api.apiinterface;

import com.api.apiinterface.client.ApiClient;
import com.api.apiinterface.model.User;

public class ApiClientTests {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
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
