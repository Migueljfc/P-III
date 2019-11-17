package aula7.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;
import java.time.temporal.TemporalAmount;

public class Aeroporto{

		static ArrayList<Voo> voos = new ArrayList<>();;
	    static HashMap<String, Cidade> cidades = new HashMap<>();
	    static HashMap<String, Companhia> companhias = new HashMap<>();

	    public static void main(String[] args) throws IOException {
	    	try {
	    	 List<String> companies = Files.readAllLines(Paths.get("aula7/ex1/companhias.txt"));
	         for(String s : companies){
	        	 String[] split = s.split("\t");
	        	 companhias.put(split[0], new Companhia(split[1], split[0]));
	         }
	         List<String> flights = Files.readAllLines(Paths.get("aula7/ex1/voos.txt"));
	         for(String s : flights){
	             String[] split = s.split("\t");
	             if(split.length == 3) {
	            	 voos.add(new Voo(LocalTime.parse(split[0]), split[1], searchCompany(split[1].substring(0,2)), searchCity(split[2]), null));
	             }
	             else {
	            
	                	 voos.add(new Voo(LocalTime.parse(split[0]), split[1], searchCompany(split[1].substring(0,2)), searchCity(split[2]),null/*(TemporalAmount)((split[3]*/));
	                	 
	                 }
	         }
	         
	            File f = new File("aula7/ex1/Infopublico.txt");
	            PrintWriter pwf = new PrintWriter(f);
	            System.out.println("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs");
	            pwf.println("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs");
	            for (Voo v : voos) {
	                System.out.println(v);
	                pwf.println(v);
	            }
	            pwf.close();

	            pwf.println();

	            ArrayList<Companhia> l = new ArrayList(companhias.values());
	            
	            System.out.println("\n\nCompanhia\tAtraso Médio");
	            for (Companhia c : l) System.out.println(c);

	            ArrayList<Cidade> l2 = new ArrayList(cidades.values());
	           
	            f = new File("aula7/ex1/cidades.txt");
	            pwf = new PrintWriter(f);
	            System.out.println("\n\nOrigem\tVoos");
	            pwf.println("\n\nOrigem\tVoos");
	            for (Cidade c : l2) {
	                System.out.println(c);
	                pwf.println(c);
	            }
	            pwf.close();
	    	}catch (Exception e){
	    		System.err.println("ERRO " + e.toString());
	        }


	}
	    
	public static Cidade searchCity(String nome) {
		if(cidades.containsKey(nome)) {
		return cidades.get(nome);
		}
		Cidade city = new Cidade(nome);
		cidades.put(nome, city);
		return city;
		
		}
		
	public static Companhia searchCompany(String sigla) {
		if(companhias.containsKey(sigla)) {
			return companhias.get(sigla);
		}
		return new Companhia(sigla,sigla);
	}

}
