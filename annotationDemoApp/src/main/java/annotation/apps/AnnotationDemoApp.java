package annotation.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.libs.Coach;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String coachName = "swimCoach";
		Coach coach = context.getBean(coachName, Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		context.close();
	}
}
