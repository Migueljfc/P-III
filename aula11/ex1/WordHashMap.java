package aula11.ex1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WordHashMap {

	public static void main(String[] args) throws IOException{
		File f = new File("/home/miguel/MEGAsync/2 ano/P3/src/aula11/ex1/Abeirense.txt");
		Scanner read = new Scanner(f);
		Map<String,Integer> mapa = new HashMap<>();
		while(read.hasNext()) {
			String word = read.next();
			if(!mapa.containsKey(word)) {
				mapa.put(word, 1);
			}
			else {
				mapa.put(word, mapa.get(word)+1);
			}
		}
		Set<Entry<String,Integer>> set = mapa.entrySet();
		Iterator<Entry<String,Integer>> i = set.iterator();
		while(i.hasNext()) {
			Entry<String,Integer> aux = i.next();
			System.out.printf("%18s %5s %d\n",aux.getKey()," ",aux.getValue());
		}
		read.close();

	}

}
