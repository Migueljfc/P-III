/*Algumas funcionalidades não estão a ser testadas mas 
	feitas no ficheiro VideoClub
*/
package aula3.exer4;

import java.util.*;
import aula1.Data;

public class Loja {

	static VideoClub videoClub = new VideoClub(5);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;

		do {
			System.out.println("Selecione uma opcao:");
			System.out.println("0 - Fechar programa.");
			System.out.println("1 - Adicionar cliente.");
			System.out.println("3 - Remover utilizador.");
			System.out.println("4 - Adicionar video.");
			System.out.println("5 - Requisitar video.");
			System.out.println("6 - Devolver video.");
			System.out.println("7 - Apresentar lista completa de videos disponiveis");
			System.out.println("8 - Apresentar lista de videos");
			System.out.println("9 - Apresentar lista completa de videos disponiveis para utilizador especifico");
			System.out.println("10 - Verificar disponibilidade de video");
			System.out.println("11 - Apresentar historico de requesicoes de video");
			System.out.println("12 - Apresentar lista ordenada de videos por rating");
			System.out.println("13 - Apresentar historico de cliente");
			
			System.out.print("Opcao : ");
			op = sc.nextInt();
			
			switch(op) {
				case 1:
					addClient();
					break;
				case 2:
					removeClient();
					break;
				case 3:
					addVideo();
					break;
				case 4:
					removeVideo();
					break;
				case 5:
					checkout();
					break;
				case 6:
					checkin();
					break;
				case 7:
					videoClub.listAvailableVideos();
					break;
				case 8:
					videoClub.listAllVideos();
					break;
				case 9:
					listVideosForUser();
					break;
				case 10:
					checkAvailability();
					break;
				case 11:
					listVideoHistory();
					break;
				case 12:
					listVideoByRating();
					break;
				case 13:
					listUserHistory();
					break;
			}
		} while (op != 0);
	}

	public static void addClient() {
		int x;
		do {
			System.out.println("Estudante(1) ou Funcionario(2)? ");
			x = sc.nextInt();
		} while (x != 1 && x != 2);

		System.out.print("Nome:");
		String name = sc.nextLine();
		sc.nextLine();

		System.out.print("CC:");
		int nCC = sc.nextInt();

		System.out.println("Data de Nascimento:");
		System.out.println("Mes:");
		int month = sc.nextInt();
		System.out.println("Dia:");
		int day = sc.nextInt();
		System.out.println("Ano:");
		int year = sc.nextInt();

		Data birth = new Data(day, month, year);

		if (x == 1) {
			System.out.println("Numero Mecanografico :");
			int nMec = sc.nextInt();
			System.out.println("Curso :");
			String course = sc.nextLine();
			sc.nextLine();

			videoClub.addClient(new Student(name, nCC, birth, nMec, course));

		} else if (x == 2) {
			System.out.println("Numero Fiscal :");
			int nFis = sc.nextInt();
			System.out.println("Numero Funcionario :");
			int nFun = sc.nextInt();

			videoClub.addClient(new Staff(name, nCC, birth, nFis, nFun));
		}
	}

	public static void removeClient() {
		System.out.print("O numero de socio do cliente que quer remover?");
		int x = sc.nextInt();
		videoClub.removeClient(x);
	}

	public static void addVideo() {
		int x;
		String idade = "";

		System.out.println("ID:");
		int id = sc.nextInt();
		System.out.println("Titulo :");
		String tit = sc.nextLine();
		sc.nextLine();
		do {
			System.out.println("Para maiores de :(6,12,16, 18 ou 0 se for para todas as idades)");
			x = sc.nextInt();
		} while (x != 6 && x != 12 && x != 16 && x != 18 && x != 0);

		if (x == 0)
			idade = "ALL";
		else if (x == 6)
			idade = "M6";
		else if (x == 12)
			idade = "M12";
		else if (x == 16)
			idade = "M16";
		else if (x == 18)
			idade = "M18";
		System.out.println("Categoria:");
		String cat = sc.next();

		videoClub.addVideo(new Video(id, tit, cat, idade));
	}

	public static void removeVideo() {
		System.out.println("O id do video que quer remover?");
		int id = sc.nextInt();

		videoClub.removeVideo(id);
		System.out.println("Eliminado com sucesso!");
	}

	public static void checkout() {
		boolean a = false;

		System.out.println("O numero de socio do cliente?");
		int nSocio = sc.nextInt();

		for (int i = 0; i < videoClub.clientList().size(); i++) {
			if (videoClub.clientList().search(i).nMember() == nSocio) {
				a = true;
			}
		}
		if (a == false) {
			System.out.println("Nao existe ninguem com esse numero!");
			return;
		}

		System.out.println("O id do video?");
		int id = sc.nextInt();
		if (a == true) {
			videoClub.lendVideo(id, nSocio);
			System.out.println("Reservado com sucesso");
		}

	}

	public static void checkin() {
		System.out.println("O numero de socio do cliente?");
		int nSocio = sc.nextInt();

		System.out.println("O id do video?");
		int id = sc.nextInt();

		videoClub.returnVideo(id, nSocio);
	}
	
	public static void listVideosForUser() {
		System.out.print("Numero socio cliente: ");
		int nMember = sc.nextInt();
		
		videoClub.listVideosForUser(nMember);
	}
		
	public static void checkAvailability() {
		System.out.print("ID Video: ");
		int idVideo = sc.nextInt();
		
		videoClub.checkAvailability(idVideo);
	}
	
	public static void listVideoHistory() {
		System.out.print("ID Video: ");
		int idVideo = sc.nextInt();
		
		videoClub.listVideoHistory(idVideo);
	}
	
	public static void listVideoByRating() {
		for(int i=0 ; i<videoClub.catalog().size() ; i++) {
			System.out.println(videoClub.sortByRating().get(i).toString());
		}
	}
	
	public static void listUserHistory() {
		System.out.print("Numero socio cliente: ");
		int nMember = sc.nextInt();
		
		videoClub.listUserHistory(nMember);
	}
}
