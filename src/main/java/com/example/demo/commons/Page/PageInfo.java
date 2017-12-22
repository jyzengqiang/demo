package com.example.demo.commons.Page;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */

public class PageInfo<T> implements Serializable{


    /**
     * 分页返回信息封装
     * 将分页集合和Page信息分开
     */


    //当前页
    int pageNum;
    //每页显示数目
    int pageSize;
    //总页数
    int totalPages;
    //总元素数量
    long totalElements;
    //集合
    private List<T> list = new ArrayList<T>();
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有后一页
    private boolean hasNextPage;

    public PageInfo() {
        this.hasPreviousPage = false;
        this.hasNextPage = false;
    }

    public PageInfo(Page page) {
        if (page.getContent().size()>0){
            this.pageNum = page.getNumber();
            this.pageSize = page.getSize();
            this.totalPages = page.getTotalPages();
            this.totalElements = page.getTotalElements();
            this.list = page.getContent();
            this.judgePageBoudary();
        }
    }

    private void judgePageBoudary() {
        this.hasPreviousPage = this.pageNum > 1;
        this.hasNextPage = this.pageNum < this.totalPages;
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
