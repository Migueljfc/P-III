package aula3.exer4;

import java.util.Calendar;
import java.util.LinkedList;

public class VideoClub {
	
	private int movieLimit;
	private ClientList clientList = new ClientList();
	private Catalog catalog = new Catalog();
	private LoanList loanList = new LoanList();
	
	public VideoClub(int n) {
		movieLimit = n;
	}
	
	public int movieLimit() {
		return movieLimit;
	}

	//Lists
	public ClientList clientList() {
		return clientList;
	}

	public Catalog catalog() {
		return catalog;
	}

	public LoanList loanList() {
		return loanList;
	}

	// Clients

	public void addClient(Person client) {
		clientList.addClient(client);
	}

	public void removeClient(int memberNum) {
		clientList.removeClient(clientList.search(memberNum));
	}

	public void listClients() {
		clientList.list();
	}

	// Videos

	public void addVideo(Video video) {
		catalog.addVideo(video);
	}

	public void removeVideo(int id) {
		catalog.removeVideo(catalog.search(id));
	}

	public void listAllVideos() {
		catalog.list();
	}

	public void listAvailableVideos() {
		catalog.listAvailable();
	}

	public void checkAvailability(int id) {
		String status = "available";
		if (!catalog.search(id).isAvailable())
			status = "unavailable";
		System.out.println("Video " + catalog.search(id).title() + " is " + status);
	}

	// Loans

	public void lendVideo(int id, int memberN) {
		Video video = catalog.search(id);
		Person client = clientList.search(memberN);
		if(client.videosPossession()>movieLimit) {
			System.out.println("Atingiu o numero limite de requisicoes!");
			return;
		}
		if (!video.isAvailable()) {
			System.out.println("Video " + catalog.search(id).title() + " is unavailable");
			return;
		}
		loanList.checkout(video, client);
		System.out.println("Video requisistado com sucesso");
	}

	public void returnVideo(int id, int memberN) {
		Video video = catalog.search(id);
		Person client = clientList.search(memberN);
		if (video.isAvailable()) {
			System.out.println(
					"Video " + catalog.search(id).title() + " is available! Cannot have 2 copies of the same video!");
			return;
		}
		loanList.checkin(video, client);
		System.out.println("Video devolvido com sucesso");
	}
	
	public void listVideosForUser(int memberN) {
		Person client = clientList.search(memberN);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - client.birthday().ano();
		int idade;
		for(int i=0 ; i<loanList.size() ; i++) {
			String s = loanList.get(i).video().age();
			if(s.equals("ALL")) {
				idade = 0;
			}
			else {
				String[] p = s.split("M");
				idade = Integer.parseInt(p[1]);
			}
			if(idade <= age) {
				System.out.println(loanList.get(i).video().toString());
			}
		}
	}
	
	public void listUserHistory(int memberN) { 
		Person client = clientList.search(memberN);
		System.out.println("Historico de "+client.name()+":"); 
		for(int i=0 ; i<loanList.size() ; i++) { 
			if(loanList.get(i).client().nMember() == memberN) {
				System.out.println(loanList.get(i).video().toString());
			}
		} 
	}
	
	public LinkedList<Video> sortByRating(){
		LinkedList<Video> tmp = catalog.catalog();
		LinkedList<Video> sorted = new LinkedList<Video>();
		double max = 0;
		Video temp = null;
		
		while (tmp.size() != sorted.size()) {
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i).averageRating() > max) {
					max = tmp.get(i).averageRating();
					temp = tmp.get(i);
				}
			}
			sorted.add(temp);
			max = 0;
			tmp.remove(temp);
		}
		return sorted;
	}
	
	public void listVideoHistory(int videoID) { 
		Video video = catalog.search(videoID);
		System.out.println("Historico de "+video.title()+":"); 
		for(int i=0 ; i<loanList.size() ; i++) { 
			if(loanList.get(i).video().idVideo() == videoID) {
				System.out.println(loanList.get(i).client().toString());
			}
		} 
	}
}
