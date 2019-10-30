package aula6.ex1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Prato {
	private static LinkedList<Alimento> alimentos = new LinkedList<Alimento>();
	private static ArrayList<Prato> pratos = new ArrayList<Prato>();
	private String nome ;
	private static double peso = 0;
	private static double calorias = 0;
	private static double proteinas = 0;
	
	public Prato(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public LinkedList<Alimento> getalimentos() {
		return alimentos;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getCalorias() {
		return calorias;
	}
	
	public double getProteinas() {
		return proteinas;
	}
	public static boolean addPrato(Prato p) {
		if(pratos.contains(p)) return false;
		return pratos.add(p); 
	}
	public static boolean delPrato(Prato p) {
		if(!pratos.contains(p)) return false;
		return pratos.remove(p);
	}
	public static void listPratos() {
		for(Prato v: pratos) {
			System.out.println(v);
		}
	}
	public static Prato find(String nome) {
		for(Prato v : pratos) {
			if (nome.equals(v.getNome())) return v;
		}
		return null;
	}
	
	public boolean addIngredientes(Alimento a) {
		if(alimentos.contains(a)) return false;
		calorias += a.getCalorias() * a.getPeso()/100;
		proteinas += a.getProteinas() * a.getPeso()/100;
		peso += a.getPeso();
		return alimentos.add(a);
		
	}
	
	public boolean delIngredientes(Alimento a) {
		if(!alimentos.contains(a)) return false;
		calorias -= a.getCalorias() * a.getPeso()/100;
		proteinas -= a.getProteinas() * a.getPeso()/100;
		peso -= a.getPeso();
		return alimentos.remove(a);
		
	}
	@Override
	public String toString() {
		return "Prato " + nome + " composto por " +alimentos.size()+ " ingredientes."  ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((alimentos == null) ? 0 : alimentos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Prato))
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (alimentos == null) {
			if (Prato.alimentos != null)
				return false;
		} else if (!alimentos.equals(Prato.alimentos))
			return false;
		return true;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Prato) {
			Prato p = (Prato) obj;
			if (calorias < p.getCalorias()) return -1;
			if(calorias > p.getCalorias()) return 1;
			return 0;
		}
		throw new IllegalArgumentException("O objeto não é um prato");
	}
	
	
	
	
	
	
	

}
