package aula3.exer4;

public class Loan {
	
	private Video video;
	private Person client;

	public Loan(Video video, Person client) {
		this.video = video;
		this.client = client;
	}

	public Video video() {
		return video;
	}

	public Person client() {
		return client;
	}
}
