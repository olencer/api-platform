package com.api.service.impl;

import com.api.common.ErrorCode;
import com.api.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.model.entity.UserInterfaceInfo;
import com.api.service.UserInterfaceInfoService;
import com.api.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author olencer
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2024-07-05 08:56:50
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Integer leftnum = userInterfaceInfo.getLeftNum();

        // 创建时，所有参数必须非空
        if (add) {
            if(id <= 0 || userId <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if(leftnum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不足");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        LambdaUpdateWrapper<UserInterfaceInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInterfaceInfo::getUserId, userId)
                .eq(UserInterfaceInfo::getInterfaceInfoId, interfaceInfoId)
                .gt(UserInterfaceInfo::getLeftNum, 0)
                .setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");

        return update(updateWrapper);
    }
}




