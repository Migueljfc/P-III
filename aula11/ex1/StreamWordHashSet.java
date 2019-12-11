package aula11.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;


public class StreamWordHashSet {

	public static void main(String[] args) throws IOException{
		File f = new File("/home/miguel/MEGAsync/2 ano/P3/src/aula11/ex1/Abeirense.txt");
		BufferedReader read = new BufferedReader(new FileReader(f));
		List<String> words = read.lines()	
				.flatMap( s-> Arrays.stream(s.trim().split(" ")))
				.filter( s -> s.length() > 0)
				//.distinct()
				.collect(Collectors.toList());
				
		System.out.println("Número Total de Palavras: " + words.size());
		System.out.println("Número de diferentes palavras: " + words.stream().distinct().count());
		read.close();
		
		
		

	}

}
