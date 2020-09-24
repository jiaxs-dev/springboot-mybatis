package com.framework.springboot.mybatis.module.privilege.service.impl;

import com.framework.springboot.mybatis.bean.po.User;
import com.framework.springboot.mybatis.bean.vo.Page;
import com.framework.springboot.mybatis.module.mapper.UserMapper;
import com.framework.springboot.mybatis.module.privilege.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.module.privilege.service.impl
 * @CreateTime: 2020-09-22 15:00
 * @Description: 用户操作service实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkUser(String username, String password) {
        List<User> userList = userMapper.checkUser(username, password);
        return null != userList && userList.size() > 0 ? true : false;
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    public Page<User> page(int pageNum, int pageSize) {
        long count = userMapper.count();
        List<User> userList = userMapper.page(pageNum, pageSize);
        return new Page<>(pageNum, pageSize, count, userList);
    }

}
