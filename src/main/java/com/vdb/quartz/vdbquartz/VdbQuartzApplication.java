package com.vdb.quartz.vdbquartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@SpringBootApplication
public class VdbQuartzApplication {

	private final String JOB_DESCRIPTION = "Invoke Job example service";

	public static void main(String[] args) {
		SpringApplication.run(VdbQuartzApplication.class, args);
	}

	/**
	 * The job's class must be provided to the JobDetail,
	 * so that it knows the type of the job to be executed.
	 */
	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob().ofType(JobExample.class)
				.storeDurably()
				.withIdentity("Quartz_Job_example")
				.withDescription(JOB_DESCRIPTION)
				.build();
	}

	/**
	 * Spring's JobDetailFactoryBean provides bean-style usage for configuring JobDetail instances. It uses the Spring bean name as the job name, if not otherwise specified:
	 * Every execution of the job creates a new instance of JobDetail.
	 * The JobDetail object conveys the detailed properties of the job. Once the execution is complete, references to the instance are dropped.
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(JobExample.class);
		jobDetailFactoryBean.setDescription(JOB_DESCRIPTION);
		jobDetailFactoryBean.setDurability(true);

		return jobDetailFactoryBean;
	}

}
