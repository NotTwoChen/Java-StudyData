package com.wsh.category.service.exception;

public class CategoryDeleteErrorException extends CategoryException {

    @Override
    public String getMessage() {
        return "分类不可删除!~";
    }
}
