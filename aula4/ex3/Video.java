package aula4.ex3;

public class Video {
	private int currentID=100;
	private int idVideo;
	private String title;
	private String category;
	private String age;
	private boolean available;
	private int nLoan=0;
	private int totalRating=0;
	private double averageRating;

	public Video(int idVideo, String title, String category, String age) {
		if (!validCategory(category) || !validAge(age))
			throw new IllegalArgumentException();
		this.idVideo = currentID++;
		this.title = title;
		this.category = category;
		this.age = age;
	}

	public int idVideo() {
		return idVideo;
	}

	public String title() {
		return title;
	}

	public String category() {
		return category;
	}

	public String age() {
		return age;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public int nLoan() {
		return nLoan;
	}
	
	public int totalRating() {
		return totalRating;
	}
	
	public double averageRating() {
		averageRating = totalRating/nLoan;
		return averageRating;
	}

	public void checkout() {
		available = false;
		nLoan++;
	}

	public void checkin() {
		available = true;
	}
	
	public void setTotalRating(int rating) {
		totalRating += rating;
	}

	public String toString() {
		return idVideo+", "+title+", "+category+", "+age+", "+isAvailable()+", "+averageRating;
	}

	private static boolean validCategory(String category) {
		return category.equals("Action") || category.equals("Comedy") || category.equals("Children")
				|| category.equals("Drama");
	}

	private static boolean validAge(String age) {
		return age.equals("ALL") || age.equals("M6") || age.equals("M12") || age.equals("M16") || age.equals("M18");
	}

}
