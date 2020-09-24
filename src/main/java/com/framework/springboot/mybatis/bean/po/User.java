package com.framework.springboot.mybatis.bean.po;

import java.util.Date;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.bean.po
 * @CreateTime: 2020-09-22 15:04
 * @Description: 用户实体类
 */
public class User {

    private long id;
    private String username;
    private String password;
    private String flag;
    private Date createTime;
    private Date updateTime;

    public User() {
        super();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String flag) {
        this.username = username;
        this.password = password;
        this.flag = flag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
