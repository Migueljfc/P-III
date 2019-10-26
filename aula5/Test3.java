package aula5;
import java.util.Scanner;
import aula5.ex3.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Test3 {
	
	static Scanner sc;
    static Agenda agenda;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
        agenda = new Agenda();
        while (true) mostrar_menu();
    }

    public static void mostrar_menu() throws FileNotFoundException {
        int escolha;
        System.out.print(""
                + "\n--------- Menu Geral ---------"
                + "\n[1] Adicionar Nova Pessoa"
                + "\n[2] Remover Pessoa Existente"
                + "\n[3] Imprimir Lista"
                + "\n[4] Alterar Ordem da Lista"
                + "\n[5] Ler de Ficheiro"
                + "\n[6] Guardar em ficheiro"
                + "\n[7] Terminar Programa"
                + "\nIntroduza a escolha: ");
        try {
            escolha = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
            sc.nextLine();
            return;
        }
        sc.nextLine();

        switch (escolha) {
        case 1:
            add_pessoa();
            break;
        case 2:
            remove_pessoa();
            break;
        case 3:
            print_lista();
            break;
        case 4:
            change_ordem();
            break;
        case 5:
            quick_load();
            break;
        case 6:
            quick_save();
            break;
        case 7:
            System.out.println(); // newline
            System.exit(0);
        default:
            System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");

        }
    }

    public static void add_pessoa() {
        int cc;
        System.out.print("\nNome da Pessoa: ");
        String nome = sc.nextLine();
        if (nome.equals("")) {
            System.out.println("****** Erro! O nome não foi preenchido! ******");
        }
        System.out.print("Número do Cartão de Cidadão: ");
        try {
            cc = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("\n****** Erro! O número do cartão de cidadão só pode conter algarismos! ******");
            sc.nextLine();
            return;
        }
        sc.nextLine();
        if (cc < 0) {
            System.out.println("\n****** Erro! Cartão de cidadão inválido! ******");
            return;
        }
        if (agenda.containsPessoa(cc)) {
            System.out.println("\n**** Erro! Este cartão de cidadão já existe na lista! ******");
            return;
        }
        System.out.print("Data de Nascimento (no formato dd-mm-aaaa): ");
        String data = sc.nextLine();
        String[] dataArr = data.split("-");
        if (dataArr.length == 3) {
            try {
                agenda.addPessoa(nome, cc, new Data(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2])));
            } catch (NumberFormatException nfe) {
                System.out.println("\n****** Erro! A data só pode conter algarismos e o delimitador '-'! ******");
                return;
            }
            catch(IllegalArgumentException iae) {
                System.out.println("\n****** Erro! A data introduzida é inválida! ******");
            }
        } else {
            System.out.println("****** Erro! Formato de data não reconhecido! ******");
        }

    }

    public static void remove_pessoa() {
        if (!agenda.isEmpty()) {
            System.out.print("\nIndique o número do cartão de cidadão da pessoa a remover: ");
            int cc = sc.nextInt();
            if (!agenda.removePessoa(cc)) {
                System.out.println("\n****** Erro! Nenhuma pessoa com esse cartão foi encontrada! ******");
            }
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }

    public static void print_lista() {
        if (!agenda.isEmpty()) {
            System.out.println("\n-------------- Lista de Pessoas --------------");
            System.out.printf("   Nome - Numero do CC - Data de Nascimento%n");
            System.out.println("----------------------------------------------");

            for (Pessoa p : agenda.getDB()) {
                System.out.println(p);
            }

            System.out.println("");
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }

    public static void change_ordem(){
        if (!agenda.isEmpty()) {
            int escolha;
            System.out.print(""
                    + "\n--- Alterar a Ordem ---"
                    + "\n[1] Ordenar por Nome"
                    + "\n[2] Ordenar por Número do CC"
                    + "\n[3] Ordenar por Data de Nascimento"
                    + "\n[4] Inverter Ordem"
                    + "\n[5] Cancelar"
                    + "\nIntroduza a escolha: ");
            try {
                escolha = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                sc.nextLine();
                return;
            }
            sc.nextLine();
            
            if(escolha < 1 || escolha > 5) {
            	System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
            	return;
            }
            else if(escolha == 5) return;
            
            agenda.changeOrder(escolha);
            System.out.println("\nOrdem alterada com sucesso");

            
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }
    
    public static File getFicheiro() {
    	String res = "";
    	do {
    		System.out.print("\nIndique o nome do ficheiro: ");
    		res = sc.nextLine();
    	} while(res.length() == 0);
    	return new File(res);
    }
    
    public static void quick_load() throws FileNotFoundException {
    	try {
    		agenda = Ficheiro.load(getFicheiro(), agenda.clone());
    	} catch(Exception e) {
    		System.out.println("\n****** Erro! " + e.getMessage() + " ******");
    		return;
    	}
    	System.out.println("\nOperação efetuada com sucesso!");
    }
    
    public static void quick_save() throws FileNotFoundException {
    	if(!agenda.isEmpty()) {
	    	String formato;
	        do {
	        	System.out.print("\nIndique o formato do ficheiro (Nokia, vCard, CSV): ");
	    		formato = sc.nextLine();
	    	} while(formato.length() == 0);
	    	try {
	    		Ficheiro.save(getFicheiro(), agenda.clone(), formato);
	    	} catch(Exception e) {
	    		System.out.println("\n****** Erro! " + e.getMessage() + " ******");
	    		return;
	    	}
	    	System.out.println("\nOperação efetuada com sucesso!");
    	} else System.out.println("\nNão existem pessoas na lista de momento.");
	}
}
