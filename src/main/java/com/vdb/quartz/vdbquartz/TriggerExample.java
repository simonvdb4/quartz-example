package com.vdb.quartz.vdbquartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

@Slf4j
public class TriggerExample implements TriggerListener {
    @Override
    public String getName() {
        return TriggerExample.class.getName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        log.info("{} trigger is fired", trigger.getKey().getName());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        log.info("{} was about to be executed but a TriggerListener vetoed it's execution", jobExecutionContext.getJobDetail().getKey().getName());
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        log.info("{} trigger was misfired", trigger.getKey().getName());
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        log.info("{} trigger is complete", trigger.getKey().getName());
    }
}
