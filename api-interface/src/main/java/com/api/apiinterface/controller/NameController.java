package com.api.apiinterface.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.api.apiinterface.model.User;
import com.api.apiinterface.utils.SignUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController()
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "get, your name: " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "post, your name: " + name;
    }

    @PostMapping("/user")
    public String getNameByPostWithJson(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String body = URLDecoder.decode(request.getHeader("body"), StandardCharsets.UTF_8.name());
        String sign = request.getHeader("sign");

        if (StrUtil.hasBlank(accessKey, body, sign, nonce, timestamp)) {
            return "has blank";
        }

        // TODO: 使用accessKey去数据库查询secretKey
        String secretKey = "api.sk";
        String serveSign = SignUtil.generateSign(body, secretKey);
        if (!StrUtil.equals(sign, serveSign)) {
            return "sign error";
        }

        // TODO 判断随机数nonce

        if (!NumberUtil.isNumber(timestamp)) {
            return "timestamp format error";
        }
        if (System.currentTimeMillis() - Long.parseLong(timestamp) > 5 * 60 * 1000) {
            return "timestamp exceeds 5 minutes";
        }

        return "post, your username: " + user.getUsername();
    }
}
