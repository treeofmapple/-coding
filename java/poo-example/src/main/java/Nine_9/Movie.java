package Nine_9;

import java.util.ArrayList;

public class Movie {

	private String title;
	private String director;
	private ArrayList<String> actors;
	private ArrayList<Review> reviews;

	public Movie(String title, String director, ArrayList<String> actors) {
		this.title = title;
		this.director = director;
		this.actors = actors;
		this.reviews = new ArrayList<Review>();
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public ArrayList<String> getActors() {
		return actors;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

}
