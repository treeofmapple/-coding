package SolidProgramming;

import Earnings.EducationalEarnings;
import Earnings.EntertainmentEarnings;
import Earnings.GamingEarnings;

public class EarningsCalculator {
	
	Category category;

	public double calculateEarnings(Video video) {
		return switch (video.getCategory()) {
			case EDUCATIONAL -> new EducationalEarnings().calculateEarnings(video);
			case GAMING -> new GamingEarnings().calculateEarnings(video);
			case ENTERTAINMENT -> new EntertainmentEarnings().calculateEarnings(video);
		};
	}
}
