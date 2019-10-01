package aula2;

import java.util.Scanner;

public class problema1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int escolha;
		do {
			System.out.println();
			System.out.println(" ____________________________________________");
			System.out.println("|                Video Clube                 |");
			System.out.println("|____________________________________________|");
			System.out.println("|   1-> Introduzir novo Estudante            |");
			System.out.println("|   2-> Introduzir novo Funcionário          |");
			System.out.println("|   3-> Remover Utilizador                   |");
			System.out.println("|   4-> Listar Utilizadores                  |");
			System.out.println("|   5-> Adicionar Filme                      |");
			System.out.println("|   6-> Remover Filme                        |");
			System.out.println("|   7-> Listar Filmes                        |");
			System.out.println("|   8-> Ver disponibilidade de um Filme      |");
			System.out.println("|   9-> Emprestimo de filme                  |");
			System.out.println("|   10-> Devolução de filme                  |");
			System.out.println("|   0-> Sair                                 |");
			System.out.println("|____________________________________________|");
			escolha = sc.nextInt();
			switch(escolha) {
			case 0:
				System.exit(0);
			break;
			case 1:
				addEstudante();
			break;
			case 2:
				addFuncionario();
			break;
			case 3:
				removerPessoa();
			break;
			case 4:
				printPessoas();
			break;
			case 5:
				addFilme();
			break;
			case 6:
				removeFilme();
			break;
			case 7:
				printVideo();
			break;
			case 8:
				disponivel();
			break;
			case 9:
				checkout();
			break;
			case 10:
				checkin();
			break;
			default:
				System.out.println("Escolha inválida");
			}
		}while(escolha != 0);
	}
	public static void addEstudante() {
		System.out.println("Digite o nome");
		String nome = sc.next();
		System.out.println("Digite o curso");
		String curso = sc.next();
		System.out.println("Digite o CC");
		int cc = sc.nextInt();
		System.out.println("Digite a data de Nascimento (dd-mm-aaaa");
		String[] dataNasc = sc.next().split("-");
		int diaNasc = Integer.parseInt(dataNasc[0]);
		int mesNasc = Integer.parseInt(dataNasc[1]);
		int anoNasc = Integer.parseInt(dataNasc[2]);
		System.out.println("Digite a data de Inscrição (dd-mm-aaaa)");
		String[] dataInsc = sc.next().split("-");
		int diaInsc = Integer.parseInt(dataInsc[0]);
		int mesInsc = Integer.parseInt(dataInsc[1]);
		int anoInsc = Integer.parseInt(dataInsc[2]);
		System.out.println("Digite o Nª MEC");
		int nMec = sc.nextInt();
		System.out.println("Digite o Nº Socio");
		int nSocio = sc.nextInt();
		ListaClientes.addPerson(new Estudante(nome,cc,new Data(diaNasc,mesNasc,anoNasc),nSocio,new Data (diaInsc,mesInsc,anoInsc), nMec,curso));
		System.out.println("Adicionado");
	}
	public static void addFuncionario() {
		System.out.println("Digite o nome");
		String nome = sc.next();
		System.out.println("Digite o Nº Fiscal");
		int nFiscal = sc.nextInt();
		System.out.println("Digite o CC");
		int cc = sc.nextInt();
		System.out.println("Digite a data de Nascimento (dd-mm-aaaa)");
		String[] dataNasc = sc.next().split("-");
		int diaNasc = Integer.parseInt(dataNasc[0]);
		int mesNasc = Integer.parseInt(dataNasc[1]);
		int anoNasc = Integer.parseInt(dataNasc[2]);
		System.out.println("Digite a data de Inscrição (dd-mm-aaaa)");
		String[] dataInsc = sc.next().split("-");
		int diaInsc = Integer.parseInt(dataInsc[0]);
		int mesInsc = Integer.parseInt(dataInsc[1]);
		int anoInsc = Integer.parseInt(dataInsc[2]);
		System.out.println("Digite o Nª Funcionário");
		int nFunc = sc.nextInt();
		System.out.println("Digite o Nº Socio");
		int nSocio = sc.nextInt();
		ListaClientes.addPerson(new Funcionario(nome,cc,new Data(diaNasc,mesNasc,anoNasc),nSocio,new Data (diaInsc,mesInsc,anoInsc), nFunc,nFiscal));
		System.out.println("Adicionado");
	}
	public static void removerPessoa() {
		System.out.println("Digite o número de sócio da pessoa a remover");
		int n = sc.nextInt();
		ListaClientes.removePerson(n);
	}
	public static void printPessoas() {
		ListaClientes.print();
	}
	public static void addFilme() {
		System.out.println("Digite o titulo do filme");
		String titulo = sc.next();
		System.out.println("Digite o ID");
		int id = sc.nextInt();
		System.out.println("Digite a categoria(ação,comédia,infantil,drama");
		String categoria = sc.next();
		System.out.println("Digite a idade minima(ALL,M6,M12,M16,M18");
		String idade = sc.next();
		Catalogo.addVideo(new Video(id,titulo,categoria,idade));
	}
	public static void printVideo() {
		Catalogo.print();
	}
	public static void removeFilme() {
		System.out.println("Digite o id do filme que pretende remover");
		int id = sc.nextInt();
		Catalogo.removeVideo(id);
	}
	public static void disponivel() {
		System.out.println("Digite o ID do Video");
		int id = sc.nextInt();
		if(!Catalogo.search(id).reservado()) {
			System.out.println("Disponível");
		}
		else{
			System.out.println("Não Disponível");
		}
	}
	public static void checkout() {
		System.out.println("Digite o id do filme");
		int id = sc.nextInt();
		Video v = Catalogo.search(id);
		if(v.reservado()) {
			System.out.println("O filme encontra-se reservado");
			return;
		}
		else {
			System.out.println("Digite o número de sócio do cliente");
			int nSocio = sc.nextInt();
			Pessoa p = ListaClientes.search(nSocio);
			System.out.println("Digite a data de empréstimo(dd-mm-aaaa)");
			String[] dataEmp = sc.next().split("-");
			int diaEmp = Integer.parseInt(dataEmp[0]);
			int mesEmp = Integer.parseInt(dataEmp[1]);
			int anoEmp = Integer.parseInt(dataEmp[2]);
			System.out.println("Digite a data de entrega(dd-mm-aaaa)");
			String[] dataEnt = sc.next().split("-");
			int diaEnt= Integer.parseInt(dataEnt[0]);
			int mesEnt = Integer.parseInt(dataEnt[1]);
			int anoEnt = Integer.parseInt(dataEnt[2]);
			
			Loja.addEmp(new Emprestimo(p,v,new Data(diaEmp,mesEmp,anoEmp),new Data(diaEnt,mesEnt,anoEnt)));
			v.checkout();
			System.out.println("Checkout");

		}
	}
	public static void checkin() {
		System.out.println("Digite o id do filme a devolver");
		int id = sc.nextInt();
		Video v = Catalogo.search(id);
		Loja.removeEmp(Loja.search(v));
		v.checkin();
	}

		
}
	
	
	


		
	

