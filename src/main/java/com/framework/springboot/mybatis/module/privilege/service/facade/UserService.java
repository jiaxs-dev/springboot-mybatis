package com.framework.springboot.mybatis.module.privilege.service.facade;

import com.framework.springboot.mybatis.bean.po.User;
import com.framework.springboot.mybatis.bean.vo.Page;

import java.util.List;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.module.privilege.service.facade
 * @CreateTime: 2020-09-22 14:59
 * @Description: 用户操作service
 */
public interface UserService {

    /**
     * 检查用户是否存在
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    boolean checkUser(String username, String password);

    List<User> list();

    Page<User> page(int pageNum, int pageSize);
}
