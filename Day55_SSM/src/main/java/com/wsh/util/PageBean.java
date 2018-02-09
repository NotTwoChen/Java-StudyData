package com.wsh.util;

import java.util.List;

public class PageBean<T> {
    // 当前页
    private int nowPageIndex;
    // 单页数据长度(数量)
    private int pageSize;
    // 所有数据的长度(数量)
    private int dataCount;

    //  总页数
    private int pageCount;
    // 数据查询起点
    private int start;
    // 页码列表的开始索引
    private int startPageIndex;
    // 页码列表的结束索引
    private int endPageIndex;
    // 单数数据集合
    private List<T> list;

    @Override
    public String toString() {
        return "PageBean{" +
                "nowPageIndex=" + nowPageIndex +
                ", pageSize=" + pageSize +
                ", dataCount=" + dataCount +
                ", pageCount=" + pageCount +
                ", start=" + start +
                ", startPageIndex=" + startPageIndex +
                ", endPageIndex=" + endPageIndex +
                ", list=" + list +
                '}';
    }

    /**
     *  构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     * @param nowPageIndex    当前页
     * @param dataCount       所有数据
     */
    public PageBean(int nowPageIndex, int dataCount) {
        this.nowPageIndex = nowPageIndex;
        this.pageSize = 5;
        this.dataCount = dataCount;
        // 计算总页数,判断总数据和单页数据量是否整除
        if (dataCount%pageSize==0){
            this.pageCount = dataCount / pageSize;
        }else {
            this.pageCount = dataCount / pageSize + 1;
        }
        // 根据当前页码和单页数据量计算出数据查询下标起点
        this.start = (nowPageIndex-1)*pageSize;
        // 初始页码列表的开始索引为1
        this.startPageIndex = 1;
        // 初始页码列表的结束索引为5
        this.endPageIndex = 5;
        // 判断总页数是否小于页码列表数目
        if (pageCount < 5){
            this.endPageIndex = this.pageCount;
        }else {
            this.startPageIndex = nowPageIndex - 2;
            this.endPageIndex = nowPageIndex + 2;
            if (startPageIndex <= 0){
                this.startPageIndex = 1;
                this.endPageIndex = 5;
            }
            if (endPageIndex > this.pageCount){
                this.endPageIndex = pageCount;
                this.startPageIndex = endPageIndex - 4;
            }
        }
    }

    public int getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(int nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStartPageIndex() {
        return startPageIndex;
    }

    public void setStartPageIndex(int startPageIndex) {
        this.startPageIndex = startPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
