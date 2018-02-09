package com.wsh.domain;

public class ServiceUpdateBak {
    private Integer id;

    private Integer serviceId;

    private Integer costId;

    public ServiceUpdateBak(Integer id, Integer serviceId, Integer costId) {
        this.id = id;
        this.serviceId = serviceId;
        this.costId = costId;
    }

    public ServiceUpdateBak() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }
}