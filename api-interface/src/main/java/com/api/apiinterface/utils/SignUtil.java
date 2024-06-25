package com.api.apiinterface.utils;

import cn.hutool.crypto.digest.DigestUtil;

public class SignUtil {
    public static String generateSign(String body, String secretKey) {
        String content = body + "." + secretKey;
        return DigestUtil.md5Hex(content);
    }
}