package lab_01.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab_01.libs.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Coach theCoach = context.getBean("myCoach", Coach.class);
//		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theCoach.getDailyFortune());
		
		Coach coach = context.getBean("myCricketCoach", Coach.class);
		context.close();
	}
}
