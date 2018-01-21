package com.wsh.bean.onetoone;

import com.wsh.util.HibernateUtil;
import org.junit.Test;

public class HusbandTest {

    @Test
    public void save(){
        HibernateUtil.handle(session -> {
            Husband husband = new Husband("赵明诚");
            Wife wife = new Wife("李清照");
            husband.setWife(wife);
            wife.setHusband(husband);
            session.save(husband);
            return null;
        });
    }

    @Test
    public void get(){
        HibernateUtil.handle(session -> {
            Husband husband = session.get(Husband.class, 4);
            System.out.println(husband.getWife());
            System.out.println(husband);
            return husband;
        });
    }

}