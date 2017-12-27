package com.saramin.lab.resumeitr.batch.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA on 2017-12-22 16:39
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : JobCompletionNotificationListener
 * Descrption :
 */
/*

@Slf4j
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("!!! Job Finished! Time to verify the");
        }
        super.afterJob(jobExecution);
    }
}
*/
