package com.api.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.api.apiclientsdk.model.User;
import com.api.apiclientsdk.utils.SignUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String GATEWAY_URL = "http://localhost:8090";
    String accessKey;
    String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getHeader(String body) throws UnsupportedEncodingException {
        Map<String, String> header = new HashMap<>();
        header.put("accessKey", accessKey);
//        header.put("secretKey", secretKey);
        header.put("nonce", RandomUtil.randomNumbers(5));
        header.put("timestamp", String.valueOf(System.currentTimeMillis()));
        header.put("body", URLEncoder.encode(body, StandardCharsets.UTF_8.name()));
        header.put("sign", SignUtil.generateSign(body, secretKey));
        return header;
    }


    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.get(GATEWAY_URL + "/api/name/", paramMap);
    }

    public String getNameByPost(String name) {
        // 可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post(GATEWAY_URL + "/api/name/", paramMap);
    }

    public String getUsernameByPost(User user) throws UnsupportedEncodingException {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_URL + "/api/name/user")
                .addHeaders(getHeader(json))
                .body(json)
                .execute();

        System.out.println(httpResponse.getStatus());
        if (httpResponse.isOk()) {
            System.out.println(httpResponse.body());
            return httpResponse.body();
        }
        return "fail";
    }
}
