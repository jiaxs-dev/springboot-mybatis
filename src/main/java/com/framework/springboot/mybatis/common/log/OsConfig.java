package com.framework.springboot.mybatis.common.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @Title: HostNameConfig
 * @Package: com.framework.springboot.mybatis.common.log
 * @Author: jiaxiansun
 * @Date: 2020/2/12
 * @Time: 10:31
 * @Description: logback输出主机操作系统名称配置
 * @Copyright: jiaxiansun@2020
 */
public class OsConfig extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return LogOutputPropertyConst.OS;
    }
}
