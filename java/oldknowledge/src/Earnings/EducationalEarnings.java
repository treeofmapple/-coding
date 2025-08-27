package Earnings;

import SolidProgramming.Video;

public class EducationalEarnings implements IEarningsCalculator{
	@Override
	public double calculateEarnings (Video video) {
		return video.getLikes() * 0.013 + video.getViews() * 0.0013;
	}
}
