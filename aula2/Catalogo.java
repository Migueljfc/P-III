package aula2;
import java.util.ArrayList;

public class Catalogo {
	static ArrayList<Video> videos = new ArrayList <Video>();
	public static void addVideo(Video video) {
		videos.add(video);
	}
	public static void removeVideo(int id) {
		for(Video v : videos.toArray(new Video[0])) {
			if (v.getId()==id) {
				videos.remove(v);
			}
			else {
				System.out.println("Video não encontrado");
			}
		}
	}
	public static void print() {
		if(videos.size()==0) {
			System.out.println("Não existem videos");
		}
		else {
			System.out.println("ID | Titulo |  Categoria | Idade Minima | Reservado |");
			for(int i = 0; i < videos.size();i++) {
				System.out.print(videos.get(i));
			}
		}
	}
	public static Video search(int id) {
		for(Video v : videos) {
			if(v.getId()== id) {
				return v;
			}
		}
		return null;
	
	}
	
	
}
