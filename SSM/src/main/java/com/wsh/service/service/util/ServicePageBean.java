package com.wsh.service.service.util;

import com.wsh.service.domain.Service;
import com.wsh.util.PageBean;

public class ServicePageBean extends PageBean<Service> {

    private String osUsername;
    private String unixHost;
    private String idcardNo;
    private String status;

    public ServicePageBean() {
    }


    @Override
    public String toString() {
        return "ServicePageBean{" +
                "osUsername='" + osUsername + '\'' +
                ", unixHost='" + unixHost + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ServicePageBean(int nowPageIndex, int dataCount, String osUsername, String unixHost, String idcardNo, String status) {
        super(nowPageIndex, dataCount);
        this.osUsername = osUsername;
        this.unixHost = unixHost;
        this.idcardNo = idcardNo;
        this.status = status;
    }

    public String getOsUsername() {

        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername;
    }

    public String getUnixHost() {
        return unixHost;
    }

    public void setUnixHost(String unixHost) {
        this.unixHost = unixHost;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public ServicePageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
}
