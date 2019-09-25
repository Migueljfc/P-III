package aula1;

import java.util.ArrayList;
import java.util.Scanner;
	
public class problema2 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Pessoa> pessoas;
	public static void main(String[] args) {
		pessoas = new ArrayList<Pessoa>();
		int escolha;
		do {
			System.out.println();
			System.out.println(" ____________________________________________");
			System.out.println("|                  Menu                      |");
			System.out.println("|____________________________________________|");
			System.out.println("|   1-> Introuzir pessoa nova                |");
			System.out.println("|   2-> Apagar pessoa                        |");
			System.out.println("|   3-> Apresentar lista completa            |");
			System.out.println("|   4-> Ordenar a lista por nome             |");
			System.out.println("|   5-> Ordenar a lista por Cartão de cidadão|");
			System.out.println("|   6-> Sair                                 |");
			System.out.println("|____________________________________________|");
			escolha = sc.nextInt();
			switch(escolha) {
			case 1:
				adicionar();
			break;
			case 2:
				remover();
			break;
			case 3:
				print();
			break;
			case 4:
				ordenarNome();
			break;
			case 5:
				ordenarCC();
			break;
			case 6: 
				System.exit(0);
			default:
				System.out.println("Escolha inválida");
			}
		}while(escolha != 6);
	}

	private static void adicionar() {
		String nome;
		int cc,dia,mes,ano = 0;
		Data data;
		System.out.println("Digite o nome da pessoa");
		nome = sc.next();
		System.out.println("Digite o número do cc");
		cc = sc.nextInt();
		do {
			System.out.println("Digite o ano de nascimento");
			ano = sc.nextInt();
			System.out.println("Digite o mês de nascimento");
			mes = sc.nextInt();
			System.out.println("Digite o dia de nascimento");
			dia = sc.nextInt();
			data = new Data(dia,mes,ano);
		}while(!data.validarData());
	
		Pessoa newPerson = new Pessoa(nome,cc,data);
		pessoas.add(newPerson);
		System.out.println("Adicionada com sucesso");
		
		
	}
	private static void remover(){
		String procurarPessoa;
		System.out.println("Digite o nome da pessoa que pretende remover");
		procurarPessoa = sc.next();
	
		for(Pessoa a: pessoas.toArray(new Pessoa[0])) {
			if(a.nome().equals(procurarPessoa)){
				pessoas.remove(a);
				
			}
			else {
				System.out.println("Pessoa não encontrada");
			}
		}
		
			
		
	}
	private static void print() {
		if(pessoas.size()==0) {
			System.out.println("Lista vazia");
		}
		else {
			System.out.println("Nome | CC | Data de Nascimento");
			for(Pessoa a : pessoas) {
				System.out.println(a);
				
			}
			System.out.println("-FIM-");
		}
	}
	private static void ordenarNome() {
		
	}
		
	public static void ordenarCC()
	{
		
	}
		
	

	
}
