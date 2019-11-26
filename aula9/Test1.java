package aula9;

import java.io.File;
import java.util.Scanner;

import aula9.ex1.ScannerAbeirense;

public class Test1 {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		ScannerAbeirense sc = null;
		System.out.print("1-Ler Tecaldo 2-Ler Ficheiro --->  Opção:");
		int op = Integer.parseInt(read.nextLine());
		switch(op) {
		case 1:
			System.out.print("Digite uma frase\n");
			String s = read.nextLine();
			sc = new ScannerAbeirense(s);
		break;
		case 2:
			sc = new ScannerAbeirense(new File("/home/miguel/Documentos/Programação3/P3/src/aula9/ex1/Abeirense.txt"));
		break;
		default:
			System.err.println("Opção Inválida");
			System.exit(0);
		}
		System.out.println("Tradução para Abeirense:");
		while(sc.hasNext()){
            System.out.print(sc.next()+" ");
        }
		read.close();
			
	}
}
