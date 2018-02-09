package com.wsh.crm.classes.service;

import com.wsh.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesService {

    List<CrmClasses> findAll();

    CrmClasses findByClassId(String classId);

    void addOrEdit(CrmClasses crmClasses);

    void upload(CrmClasses crmClasses);
}
