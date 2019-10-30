package aula6;
import aula6.ex1.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Ementa2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int escolha;
		Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");
		do {
			System.out.println();
			System.out.println("____________________________________________");
			System.out.println("                     Menu                   ");
			System.out.println("____________________________________________");
			System.out.println("   Ingrediente:");
			System.out.println("   	    1-> Adiconar Carne");
			System.out.println("  		2-> Adicionar Peixe");
			System.out.println("  		3-> Adiconar Cereal");
			System.out.println("   	    4-> Adicionar Legume");
			System.out.println("  		5-> Listar Ingredientes");
			System.out.println("____________________________________________");
			System.out.println("   Prato:");
			System.out.println("  		6-> Criar Prato");
			System.out.println("        7-> Apagar Prato");
			System.out.println("  		8-> Listar Pratos");
			System.out.println("    	9-> Adicionar Ingredientes");
			System.out.println("        10-> Remover Ingredientes");
			System.out.println("____________________________________________");
			System.out.println("  Ementa:");
			System.out.println("       11-> Adicionar Prato");
			System.out.println("       12-> Remover Prato");
			System.out.println("       13-> Imprimir Ementa");
			System.out.println("       14-> Importar Ementa");
			System.out.println("       15-> Guardar Ementa");
			System.out.println("____________________________________________");
			System.out.println("                                  SAIR -> 0 ");
			System.out.println("____________________________________________");
			
			escolha = sc.nextInt();
			switch(escolha) {
			case 0:
				System.exit(0);
			break;
			case 1:
				addCarne();
			break;
			case 2: 
				addPeixe();
			break;
			case 3:
				addCereal();
			break;
			case 4:
				addLegume();
			break;
			case 5:
				Alimento.listAlimentos();
			break;
			case 6:
				addPrato();
			break;
			case 7:
				dellPrato();
			break;
			case 8:
				Prato.listPratos();
			break;
			case 9:
				addIngredientes();
			break;
			case 10:
				//delIngredintes();
			break;
			case 11:
				addPrato_Ementa();
			break;
			case 12:
				dellPrato_Ementa();
			break;
			case 13:
				System.out.println(ementa.toString());
			break;
			default:
				System.err.println("Opção inválida");
			break;	
			
	}
	}while(escolha != 0);

}
	public static void addCarne() {
		double proteinas,calorias,peso;
		int variety;
		System.out.print("\nProteínas por 100g: ");
		proteinas = sc.nextDouble();
		System.out.print("Calorias por 100g: ");
		calorias = sc.nextDouble();
		System.out.print("Peso");
        peso = sc.nextDouble();
        System.out.print("Variedade de carne : vaca(0),porco(1),peru(2),frango(3),outra(4)");
        variety = sc.nextInt();
		Alimento.addAlimento(new Carne(proteinas,calorias,peso,Variedade.values()[variety]));
	}
	public static void addPeixe() {
		double proteinas,calorias,peso;
		int tipo;
		System.out.print("\nProteínas por 100g: ");
		proteinas = sc.nextDouble();
		System.out.print("Calorias por 100g: ");
		calorias = sc.nextDouble();
		System.out.print("Peso");
        peso = sc.nextDouble();
        System.out.println("Tipo de peixe: congelado(0),fresco(1)");
        tipo = sc.nextInt();
        Alimento.addAlimento(new Peixe(proteinas,calorias,peso,Tipo.values()[tipo]));
	}
	public static void addCereal() {
		double proteinas,calorias,peso;
		String nome;
		System.out.print("Nome:");
		nome = sc.next();
		System.out.print("\nProteínas por 100g: ");
		proteinas = sc.nextDouble();
		System.out.print("Calorias por 100g: ");
		calorias = sc.nextDouble();
		System.out.print("Peso");
        peso = sc.nextDouble();
        Alimento.addAlimento(new Cereal(proteinas,calorias,peso,nome));
	}
	public static void addLegume() {
		double proteinas,calorias,peso;
		String nome;
		System.out.print("Nome:");
		nome = sc.next();
		System.out.print("\nProteínas por 100g: ");
		proteinas = sc.nextDouble();
		System.out.print("Calorias por 100g: ");
		calorias = sc.nextDouble();
		System.out.print("Peso");
        peso = sc.nextDouble();
        Alimento.addAlimento(new Legume(proteinas,calorias,peso,nome));
	}
	public static void addPrato() {
		System.out.print("Nome: ");
		Prato.addPrato(new Prato(sc.next()));
	}
	public static void dellPrato() {
		System.out.print("Nome :");
		String nome = sc.next();
		Prato.delPrato(Prato.find(nome));
	}
	public static void addIngredientes() {
		// System.out.print("Id do ingrediente da lista de ingredientes");
		// int id = sc.nextInt();
		//Prato.addIngredientes(Alimento.find(id));
	}
	public static void addPrato_Ementa() {
		int dia;
		String nome;
		System.out.println("Digite o dia da semana Segunda(0),Terça(1),...");
		dia = sc.nextInt();
		System.out.println("Digite o nome do prato");
		nome = sc.next();
		try {
			Prato.find(nome);
		}catch(InputMismatchException ime) {
			System.out.println("Prato não encontrado");
			return;
		}
		Ementa.addPrato(Prato.find(nome),DiaSemana.values()[dia]);
	}
	public static void dellPrato_Ementa() {
		String nome;
		System.out.println("Digite o nome do prato");
		nome = sc.next();
		try {
			Ementa.find(nome);
		}catch(InputMismatchException ime) {
			System.out.println("Prato não encontrado");
		}
		Ementa.dellPrato(Prato.find(nome));
			
	}
		
}
	

