package com.framework.springboot.mybatis.module.mapper;

import com.framework.springboot.mybatis.bean.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.module.privilege.mapper
 * @CreateTime: 2020-09-22 14:49
 * @Description: UserMapper
 */
@Mapper
@Repository
public interface UserMapper {

    @SelectProvider(value = SqlBuilder.class, method = "checkUser")
    @Results(id = "user", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "flag", property = "flag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<User> checkUser(String username, String password);

    @ResultMap(value = "user")
    @Select(value = "select * from user")
    List<User> list();

    @Select(value = "select count(id) from user")
    long count();

    @SelectProvider(value = SqlBuilder.class, method = "page")
    @ResultMap(value = "user")
    List<User> page(int pageNum, int pageSize);

    class SqlBuilder {
        public static String checkUser(String username, String password) {
            return "select * from user where username = '" + username + "' and password = '" + password + "'";
        }

        public static String page(int pageNum, int pageSize) {
            int pageIndex = (pageNum - 1) * pageSize;
            return "select * from user limit " + pageIndex + "," + pageSize;
        }
    }
}
