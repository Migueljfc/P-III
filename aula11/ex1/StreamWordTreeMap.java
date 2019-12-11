package aula11.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
//import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWordTreeMap {
	public static void main(String[] args) throws IOException{
		File f = new File("/home/miguel/MEGAsync/2 ano/P3/src/aula11/ex1/Abeirense.txt");
		BufferedReader read = new BufferedReader(new FileReader(f));
		List<String> words = read.lines()	
                .flatMap((str) -> Arrays.stream(str.trim().split(" ")))
                .filter((str) -> str.length() > 0)
                .sorted()
                .collect(Collectors.toList());
		//Collections.sort(words,Collator.getInstance());
    	System.out.println(words.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())));
    	read.close();

	}
}
