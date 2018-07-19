/**
 * 
 */
package com.example.demo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author LOL
 * 2017年11月22日下午3:09:46
 */
@Configuration
@EnableScheduling // 启用定时任务
public class TestTask {
	//@Scheduled(cron="0/10 * * * * ?") 
    public void executeFileDownLoadTask() {
        Thread current = Thread.currentThread();  
        System.out.println("定时任务1:"+current.getId());
    }
	 
	//@Scheduled(cron="0/5 * * * * ?") 
    public void executeFileDownLoadTask1() {
           
        Thread current = Thread.currentThread();  
        System.out.println("定时任务2:"+current.getId());
    }
}
