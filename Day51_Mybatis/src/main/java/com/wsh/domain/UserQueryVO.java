package com.wsh.domain;

import java.util.Date;
import java.util.List;

public class UserQueryVO {
    public UserQueryVO() {
    }

    private UserExt userExt;
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public UserExt getUserExt() {
        return userExt;
    }

    public void setUserExt(UserExt userExt) {
        this.userExt = userExt;
    }
}
