package com.lanou3g.study;

public class ThreadDemo extends Thread{
    // 打算在创建ThreadDemo的时候,传进来一个Ticket对象
    // 应该怎么做

    private Ticket ticket;

    public ThreadDemo(String name,Ticket ticket) {
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        ticket.sellTicket();
    }


}
