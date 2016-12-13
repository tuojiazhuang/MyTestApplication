package com.ali.android.threadtestapp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
     * @author zejian
     * @time 2016年3月12日 下午2:55:42
     * @decrition 模拟卖票线程
     */
    public class Ticket implements Runnable
    {
        Lock ticketLock = new ReentrantLock();
        //当前拥有的票数
        private  int num = 100;
        public void run()
        {
            while(true)
            {
                ticketLock.lock();
                if(num>0)
                {
                    try{Thread.sleep(100);}catch (InterruptedException e){}
                    //输出卖票信息
                    System.out.println(Thread.currentThread().getName()+".....sale...."+num--);
                }
            }
        }
    }