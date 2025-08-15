package Earnings;

import SolidProgramming.Video;

public class GamingEarnings implements IEarningsCalculator {
	@Override
	public double calculateEarnings (Video video) {
		return video.getLikes() * 0.012 + video.getViews() * 0.0012;
	}
}
