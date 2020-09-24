package com.framework.springboot.mybatis.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: RedisController
 * @Package: com.framework.springboot.mybatis.common.redis
 * @Author: jiaxiansun
 * @Date: 2020/5/7
 * @Time: 17:48
 * @Description: redis测试controller
 * @Copyright: jiaxiansun@2020
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    ValueOperations valueOperations;


    @RequestMapping("/put")
    public boolean put(@RequestParam String key, @RequestParam String value) throws Exception {
        valueOperations.set(key, value);
        return true;
    }

    @RequestMapping("/get")
    public String get(@RequestParam String key) throws Exception {
        return valueOperations.get(key).toString();
    }
}
