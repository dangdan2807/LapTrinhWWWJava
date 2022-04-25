package lab_01.libs;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;

	public final void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
	}

	public final void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: inside setter method - setTeam");
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public String getDailyWorkout() {
		return null;
	}

	public String getDailyFortune() {
		return null;
	}

}
