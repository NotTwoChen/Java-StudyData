package com.wsh.category.service.exception;

public class CategoryInsertErrorException extends CategoryException {
    @Override
    public String getMessage() {
        return "增加分类失败!~";
    }
}
