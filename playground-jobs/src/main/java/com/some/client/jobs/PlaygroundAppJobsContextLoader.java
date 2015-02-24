package com.some.client.jobs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlaygroundAppJobsContextLoader {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jobs-context.xml");
    }
}
