package aula5.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Ficheiro {
	
	public static Agenda load(File f, Agenda agenda) throws FileNotFoundException {
		if(!(f.exists() && f.isFile() && f.canRead())) throw new IllegalArgumentException("Ficheiro não existe ou não pode ser lido!");
		Scanner scf = new Scanner(f);
		switch(scf.nextLine()) {
		case "Nokia":
			return loadNokia(scf, agenda);
		case "vCard":
			return loadVCard(scf, agenda);
		case "CSV":
			return loadCSV(scf, agenda);
		default:
			scf.close();
			throw new IllegalArgumentException("Formato desconhecido!");
		}
	}
	
	private static Data verificarInfo(Agenda agenda, String nome, int cc, String data) {
		Data d;
		if (nome.length() == 0) throw new IllegalArgumentException("Nome inválido detetado! Verificar Formato!");
		if (cc < 0) throw new IllegalArgumentException("Cartão de cidadão inválido!");
		if (agenda.containsPessoa(cc)) throw new IllegalArgumentException("Existem pessoas com o mesmo CC!");
		String[] dataArr = data.split("/");
        if (dataArr.length == 3) {
            try {
                d = new Data(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException("A data só pode conter algarismos e o delimitador!");
            }
        } else {
            throw new IllegalArgumentException("Formato de data inválido!");
        }
        return d;
	}
	
	private static Agenda loadNokia(Scanner scf, Agenda agenda) {
		while(scf.hasNextLine()) {
			String nome = scf.nextLine();
			int cc = scf.nextInt();
			scf.nextLine();
			String d = scf.nextLine();
			Data data = verificarInfo(agenda,nome,cc,d);
			agenda.addPessoa(nome, cc, data);
			if(scf.hasNextLine()) scf.nextLine();
		}
		scf.close();
		return agenda;
	}
	
	private static Agenda loadVCard(Scanner scf, Agenda agenda) {
		while(scf.hasNextLine()) {
			String[] pessoa = scf.nextLine().split("#");
			if (pessoa.length == 4) {
				String nome = pessoa[1];
				int cc = Integer.parseInt(pessoa[2]);
				String d = pessoa[3];
				Data data = verificarInfo(agenda,nome,cc,d);
				agenda.addPessoa(nome, cc, data);
	        } else {
	            throw new IllegalArgumentException("Formato inválido!");
	        }
		}
		scf.close();
		return agenda;
	}
	
	private static Agenda loadCSV(Scanner scf, Agenda agenda) {
		while(scf.hasNextLine()) {
			String[] pessoa = scf.nextLine().split("\t");
			if (pessoa.length == 3) {
				String nome = pessoa[0];
				int cc = Integer.parseInt(pessoa[1]);
				String d = pessoa[2];
				Data data = verificarInfo(agenda,nome,cc,d);
				agenda.addPessoa(nome, cc, data);
	        } else {
	            throw new IllegalArgumentException("Formato inválido!");
	        }
		}
		scf.close();
		return agenda;
	}
	
	public static void save(File f, Agenda agenda, String formato) throws FileNotFoundException {
		if(f.exists() && !(f.isFile() && f.canWrite())) throw new IllegalArgumentException("Ficheiro não pode ser escrito!");
		PrintWriter pwf = new PrintWriter(f);
		switch(formato) {
		case "Nokia":
			pwf.print("Nokia");
			ArrayList<Pessoa> lista = agenda.getDB();
			for(int i = 0; i < lista.size(); i++) {
				if(i != 0) pwf.println();
				pwf.printf("%n%s%n%d%n%s", lista.get(i).nome(), lista.get(i).cc(), lista.get(i).dataNasc().toString());
			}
			break;
		case "vCard":
			pwf.print("vCard");
			for(Pessoa p : agenda.getDB()) pwf.printf("%n#%s#%d#%s", p.nome(), p.cc(), p.dataNasc().toString());
			break;
		case "CSV":
			pwf.print("CSV");
			for(Pessoa p : agenda.getDB()) pwf.printf("%n%s\t%d\t%s", p.nome(), p.cc(), p.dataNasc().toString());
			break;
		default:
			pwf.close();
			throw new IllegalArgumentException("Formato desconhecido!");
		}
		pwf.close();
	}

}