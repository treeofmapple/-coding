package Earnings;

import SolidProgramming.Video;

public class Service {
	IEarningsCalculator calculator;
	
	public Service (IEarningsCalculator calculator) {
		this.calculator = calculator;
	}
	
	public double calculatorEarnings (Video video) {
		return calculator.calculateEarnings(video);
	}
	
}
