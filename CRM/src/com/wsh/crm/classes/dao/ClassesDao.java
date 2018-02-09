package com.wsh.crm.classes.dao;

import com.wsh.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesDao {

    List<CrmClasses> queryAll();

    CrmClasses queryByClassId(String classId);

    void insertOrUpdate(CrmClasses crmClasses);

    void updateUpload(CrmClasses crmClasses);
}
