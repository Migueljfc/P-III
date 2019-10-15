package aula4.ex3;

import java.util.LinkedList;

public class LoanList {

	private LinkedList<Loan> loanList = new LinkedList<Loan>();

	public void checkout(Video video, Person client) {
		loanList.add(new Loan(video, client));
		video.checkout();
		client.checkout();
	}

	public void checkin(Video video, Person client) {
		video.checkin();
		client.checkin();
	}
	
	public int size() {
		return loanList.size();
	}

	public Loan get(int x) {
		return loanList.get(x);
	}
}
