package com.framework.springboot.mybatis.module.privilege.controller;

import com.framework.springboot.mybatis.bean.vo.Page;
import com.framework.springboot.mybatis.bean.vo.R;
import com.framework.springboot.mybatis.common.utils.HttpRequestUtil;
import com.framework.springboot.mybatis.module.privilege.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.module.privilege.controller
 * @CreateTime: 2020-09-22 15:15
 * @Description: UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户名密码校验
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/checkUser")
    public R checkUser(String username, String password) {
        return R.suceess(userService.checkUser(username, password));
    }

    @RequestMapping("/list")
    public R list() {
        return R.suceess(userService.list());
    }

    @RequestMapping("/page")
    public R page(@RequestParam String key, @RequestParam int pageNum, @RequestParam int pageSize) throws Exception {
        return R.suceess(userService.page(pageNum, pageSize));
    }

    @RequestMapping("/pageJson")
    public R pageJson(HttpServletRequest request) throws Exception {
        return R.suceess(HttpRequestUtil.parseRequestParams(request));
    }
}
