package annotation.libs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public SwimCoach() {
		System.out.println(">>SwimCoach: inside default constructor");
	}

	public String getDailyWorkout() {
		return "Swim 1000 meters as warm up";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("SwimCoach: inside method doMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("SwimCoach: inside method doMyCleanupStuff");
	}
}
