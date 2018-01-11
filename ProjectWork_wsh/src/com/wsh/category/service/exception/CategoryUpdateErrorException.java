package com.wsh.category.service.exception;

public class CategoryUpdateErrorException extends CategoryException {
    @Override
    public String getMessage() {
        return "分类修改失败!~";
    }
}
