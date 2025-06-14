package Earnings;

import SolidProgramming.Video;

public class EntertainmentEarnings implements IEarningsCalculator {
	@Override
	public double calculateEarnings (Video video) {
		return video.getLikes() * 0.011 + video.getViews() * 0.0011;
	}
}
