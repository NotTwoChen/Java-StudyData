package com.wsh.crm.classes.service.impl;

import com.wsh.crm.classes.dao.ClassesDao;
import com.wsh.crm.classes.domain.CrmClasses;
import com.wsh.crm.classes.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesDao classesDao;

    @Override
    public List<CrmClasses> findAll() {
        return classesDao.queryAll();
    }

    @Override
    public CrmClasses findByClassId(String classId) {
        return classesDao.queryByClassId(classId);
    }

    @Override
    public void addOrEdit(CrmClasses crmClasses) {
        classesDao.insertOrUpdate(crmClasses);
    }

    @Override
    public void upload(CrmClasses crmClasses) {
        classesDao.updateUpload(crmClasses);
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }
}
