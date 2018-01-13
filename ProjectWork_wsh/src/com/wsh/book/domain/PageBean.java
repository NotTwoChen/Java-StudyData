package com.wsh.book.domain;

import java.util.List;

public class PageBean<T> {
    private int pageCode;//当前页
    private int pageSize;//单页数据数量
    private int totalData;//总数据集合长度

    private int totalPage;//总页数
    private int start;//limit参数1,即数据查询下标起点
    private int end;//limit参数2,即数据查询下标个数
    private int startPage;//分页显示的页头
    private int endPage;//分页显示的页尾
    private List<T> list;//单页数据集合

    public PageBean(int pageCode, int pageSize, int totalData) {
        this.pageCode = pageCode;
        this.pageSize = pageSize;
        this.totalData = totalData;
        if (totalData%pageSize==0){
            this.totalPage = totalData / pageSize;
        }else {
            this.totalPage = totalData / pageSize + 1;
        }
        this.start = (pageCode-1)*pageSize;
        this.end = pageCode*pageSize;//TODO
        this.startPage = 1;
        this.endPage = 5;
        if (totalPage < 5){
            this.endPage = this.totalPage;
        }else {
            this.startPage = pageCode - 2;
            this.endPage = pageCode + 2;
            if (startPage <= 0){
                this.startPage = 1;
                this.endPage = 5;
            }
            if (endPage > this.totalPage){
                this.endPage = totalPage;
                this.startPage = endPage - 4;
            }
        }
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
