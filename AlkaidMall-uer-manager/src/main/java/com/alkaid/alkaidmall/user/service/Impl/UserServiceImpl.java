package com.alkaid.alkaidmall.user.service.Impl;

import com.Alkaid.AlkaidMall.UserService;
import com.Alkaid.AlkaidMall.bean.UserAddress;
import com.Alkaid.AlkaidMall.bean.UserInfo;
import com.alkaid.alkaidmall.user.mapper.UserAddressMapper;
import com.alkaid.alkaidmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(userId);
        return userAddressMapper.select(userAddress);
    }
}
