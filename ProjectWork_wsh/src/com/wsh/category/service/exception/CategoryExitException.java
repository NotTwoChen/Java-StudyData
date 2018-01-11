package com.wsh.category.service.exception;

public class CategoryExitException extends CategoryException {
    @Override
    public String getMessage() {
        return "分类不存在!~";
    }
}
