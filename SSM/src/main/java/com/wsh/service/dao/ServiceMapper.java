package com.wsh.service.dao;

import com.wsh.service.domain.Service;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ServiceMapper {

    int deleteByPrimaryKey(Integer serviceId);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceId);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    List<Service> selectAll(HashMap<String,Object> map);

    List<Service> selectAllByPage(HashMap<String, Object> map);

    void updateStatus(Service service);

}