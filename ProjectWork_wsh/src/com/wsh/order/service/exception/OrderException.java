package com.wsh.order.service.exception;

public class OrderException extends Exception {
    @Override
    public String getMessage() {
        return "订单确认失败!~";
    }
}
