package Scheduler;

import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduler 
{
   public static void main(String args[]) throws Exception
   {
	   try 
	   {
		   JobDetail job = JobBuilder.newJob(BirthDayEmailJob.class)
	                .withIdentity("BirthdayEmailJob", "emailGroup")
	                .build();
	    
	   
	   Trigger trigger = TriggerBuilder.newTrigger()
               .withIdentity("dailyTrigger", "emailGroup")
               .startNow()
               .withSchedule(SimpleScheduleBuilder.simpleSchedule()
               .withIntervalInSeconds(10)
               .repeatForever())
               .build();

       Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
       scheduler.start();
       
       scheduler.scheduleJob( job ,trigger);

       System.out.println(" Quartz Scheduler started. Job will run every 10 seconds...");
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
   }
   }

