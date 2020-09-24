package com.framework.springboot.mybatis.bean.vo;

/**
 * @Title: Page
 * @Package: com.framework.springboot.mybatis.bean.vo
 * @Author: jiaxiansun
 * @Date: 2020/2/17
 * @Time: 15:55
 * @Description: 分页结果类
 * @Copyright: jiaxiansun@2020
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_NUM = 1;

    private int pageNum = 1;//页码
    private int pageSize = 10;//每页大小
    private long totalCount;//查询结果总数
    private long totalPageCount;//总共多少页
    private List<E> data;//当前页数据详情

    public Page() {
        this(DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE, 0, new ArrayList<E>());
    }

    public Page(int pageNum, int pageSize, long totalCount, List<E> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = getTotalPageCount();
        this.data = data;

    }

    protected long getTotalPageCount() {
        if (this.totalCount % this.pageSize == 0) {
            return this.totalCount / this.pageSize;
        } else {
            return this.totalCount / this.pageSize + 1;
        }
    }

    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageCount(long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
