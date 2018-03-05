package com.wsh.service.service.impl;

import com.wsh.account.dao.AccountMapper;
import com.wsh.account.domain.Account;
import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import com.wsh.service.domain.Service;
import com.wsh.service.dao.ServiceMapper;
import com.wsh.service.service.ServiceService;
import com.wsh.service.service.util.ServicePageBean;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service("serviceService")
@Transactional
public class ServiceServiceImpl implements ServiceService{

    @Resource
    private ServiceMapper serviceMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private CostMapper costMapper;

    @Override
    public ServicePageBean queryAllByPage(ServicePageBean pageBean) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("osUsername",pageBean.getOsUsername());
        map.put("unixHost",pageBean.getUnixHost());
        map.put("idcardNo",pageBean.getIdcardNo());
        map.put("status",pageBean.getStatus());
        pageBean = new ServicePageBean(pageBean.getNowPageIndex(), serviceMapper.selectAll(map).size(), pageBean.getOsUsername(), pageBean.getUnixHost(), pageBean.getIdcardNo(), pageBean.getStatus());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        pageBean.setList(serviceMapper.selectAllByPage(map));
        return pageBean;
    }

    @Override
    public Map<String, Object> updateServiceStart(int service_id) {
        Map<String,Object> info = new HashMap<>();
        Service service = serviceMapper.selectByPrimaryKey(service_id);
        if (!service.getAccount().getStatus().equals("1")){
            info.put("success",false);
            info.put("message","账务账号没有开通,不允许开通当前业务账号!");
        }else {
            service.setStatus("1");
            serviceMapper.updateStatus(service);
            info.put("success",true);
            info.put("message","业务账号开通成功!");
        }
        return info;
    }

    @Override
    public Map<String, Object> updateServicePause(int service_id) {
        Map<String,Object> info = new HashMap<>();
        Service service = serviceMapper.selectByPrimaryKey(service_id);
        service.setStatus("2");
        serviceMapper.updateStatus(service);
        info.put("success",true);
        info.put("message","业务账号暂停成功!");
        return info;
    }

    @Override
    public Map<String, Object> queryAccountByIdcardNo(String idcardNo) {
        Account account = accountMapper.selectByIdcardNo(idcardNo);
        Map<String,Object> map = new HashMap<>();
        map.put("accountId",account.getAccountId());
        return map;
    }

    @Override
    public List<Cost> queryAllCost() {
        return costMapper.selectAll();
    }

    @Override
    public void addService(Service service) {
        service.setStatus("1");
        service.setCreateDate(new Timestamp(System.currentTimeMillis()));
        serviceMapper.insertSelective(service);
    }

    @Override
    public Service queryByServiceId(Integer service_id) {
        return serviceMapper.selectByPrimaryKey(service_id);
    }

    @Override
    public void updateService(Service service) {
        serviceMapper.updateByPrimaryKeySelective(service);
    }

    @Override
    public void deleteService(Integer service_id) {
        Service service = serviceMapper.selectByPrimaryKey(service_id);
        service.setStatus("3");
        serviceMapper.updateStatus(service);
    }
}
