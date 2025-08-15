package SolidProgramming;

public class Video implements IVideoActions, IAdsActions {

	private String title;
	private int time;
	private int likes;
	private int views;
	private Category category;
	
	public double getNumberOfHoursPlayed() {
		return (time / 3600.0) * views;
	}
	
	public void playRandomAd() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public int getTime() {
		return time;
	}
	public int getLikes() {
		return likes;
	}
	public int getViews() {
		return views;
	}
	
	public Category getCategory() {
		return category;
	}
	
	
}
