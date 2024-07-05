package com.api.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvokeInterfaceRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     */
    private String requestParams;

}
