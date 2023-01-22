package com.vdb.quartz.vdbquartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

@Slf4j
public class JobListenerExample implements JobListener {
    @Override
    public String getName() {
        return JobListenerExample.class.getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        log.info("{} is to be executed", jobExecutionContext.getJobDetail().getKey().getName());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        log.info("{} vetoed cause there was an exception", jobExecutionContext.getJobDetail().getKey().getName());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        log.info("{} executed", jobExecutionContext.getJobDetail().getKey().getName());
    }
}
