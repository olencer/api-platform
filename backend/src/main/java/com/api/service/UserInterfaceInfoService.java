package com.api.service;

import com.api.model.entity.InterfaceInfo;
import com.api.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author olencer
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2024-07-05 08:56:50
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo,
                                boolean add);
    boolean invokeCount(long interfaceInfoId, long userId);
}
