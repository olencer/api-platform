package com.api.service;

import com.api.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author olencer
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-06-23 21:25:07
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
