package com.wsh.util;

import java.util.UUID;

public class GetUUID {
    public GetUUID() {
    }

    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
