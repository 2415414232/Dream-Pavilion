package com.dangle.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by 党桢乐 on 2020/4/24
 * 将线程池单例
 */
public class WoExecutor {
    private  static  class WoExecutors{
        private  static ExecutorService service= Executors.newFixedThreadPool(8);
    }
    public  static  ExecutorService getExecutor(){
        return WoExecutors.service;
    }
}
