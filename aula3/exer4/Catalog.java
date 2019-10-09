package aula3.exer4;

import java.util.LinkedList;

public class Catalog {
	private LinkedList<Video> catalog = new LinkedList<Video>();

	public void addVideo(Video video) {
		catalog.add(video);
	}

	public void removeVideo(Video video) {
		catalog.remove(video);
	}

	public int size() {
		return catalog.size();
	}
	
	public LinkedList<Video> catalog(){
		return catalog;
	}

	public void list() {
		System.out.println("List:");
		System.out.printf("%10s || %10s || %10s || %10s || %10s || %10s\n", "ID", "Title", "Category", "Age", "Booking status", "Average Rating");
		System.out.println("----------------------------------------------------------------------------------");
		for (int i = 0; i < catalog.size(); i++) {
			System.out.println(catalog.get(i).toString());
		}
	}

	public void listAvailable() {
		System.out.println("List of available videos:");
		System.out.printf("%10s || %10s || %10s || %10s\n", "ID", "Title", "Category", "Age");
		System.out.println("----------------------------------------------------------------------------------");
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).isAvailable())
				System.out.println(catalog.get(i).toString());
		}
	}

	public Video search(int id) {
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).idVideo() == id)
				return catalog.get(i);
		}
		throw new IllegalArgumentException();
	}
}
