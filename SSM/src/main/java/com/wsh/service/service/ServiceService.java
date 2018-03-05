package com.wsh.service.service;

import com.wsh.cost.domain.Cost;
import com.wsh.service.domain.Service;
import com.wsh.service.service.util.ServicePageBean;

import java.util.List;
import java.util.Map;

public interface ServiceService {

    ServicePageBean queryAllByPage(ServicePageBean pageBean);

    Map<String,Object> updateServiceStart(int service_id);

    Map<String,Object> updateServicePause(int service_id);

    Map<String,Object> queryAccountByIdcardNo(String idcardNo);

    List<Cost> queryAllCost();

    void addService(Service service);

    Service queryByServiceId(Integer service_id);

    void updateService(Service service);

    void deleteService(Integer service_id);
}
