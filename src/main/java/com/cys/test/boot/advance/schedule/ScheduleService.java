package com.cys.test.boot.advance.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleService {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void testFixedRate(){
        System.out.println("fixedRate:" + dateFormat.format(new Date()));
    }
    @Scheduled(cron = "0 0/1 * * * *")
    public void testCron(){
        System.out.println("cron:" + dateFormat.format(new Date()));
    }
}
