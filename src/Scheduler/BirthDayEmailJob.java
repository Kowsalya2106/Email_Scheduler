package Scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import DataBaseConnection.DatabaseConnection;

public class BirthDayEmailJob implements Job
{
	   @Override
	    public void execute(JobExecutionContext context) throws JobExecutionException 
	     {
	        System.out.println("Quartz Job Triggered: Sending birthday emails..."+java.time.LocalDate.now());
	        DatabaseConnection.sendEmail(); //sendBirthdayEmails(); // Your existing logic
	    }
}
