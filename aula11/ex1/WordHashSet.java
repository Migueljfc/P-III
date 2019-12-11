package aula11.ex1;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordHashSet {

	public static void main(String[] args) throws IOException{
		Set<String> s = new HashSet<String>();
		int i = 0;
		File f = new File("/home/miguel/MEGAsync/2 ano/P3/src/aula11/ex1/Abeirense.txt");
		Scanner read = new Scanner(f);
		while(read.hasNext()) {
			s.add(read.next());
			i++;
		}
		System.out.println("Número Total de Palavras: "+i);
		System.out.println("Número de diferentes palavras: "+ s.size());
		read.close();
	}
	
}
