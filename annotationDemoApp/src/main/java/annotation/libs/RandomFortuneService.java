package annotation.libs;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data = {
			"Beware of the woft in sleep'c clothing",
			"Diligence is mother of good luck",
			"The journey is the reward"
	};
	
	private Random random = new Random();
	
	public String getFortune() {
		int index = random.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
