package aula6.ex1;

import java.util.ArrayList;

public class Alimento {
	private static double proteinas;
	private static double calorias;
	private static double peso;
	private static int id;
	private int count = 0;
	static ArrayList<Alimento> ingredientes = new ArrayList<Alimento>();

	public Alimento(double proteinas,double calorias,double peso) {
		Alimento.proteinas = proteinas;
		Alimento.peso = peso;
		Alimento.calorias = calorias;
		Alimento.id = count++;
	}
	public int getId() {
		return id;
	}
	public double getProteinas() {
		return proteinas;
	}
	public double getCalorias() {
		return calorias;
	}
	public double getPeso() {
		return peso;
	}
	
	public static boolean addAlimento (Alimento a) {
		if(ingredientes.contains(a)) return false;
		return ingredientes.add(a);	
	}
	
	public static boolean delAlimentos(Alimento a) {
		if(!ingredientes.contains(a)) return false;
		return ingredientes.remove(a);
		
	}
	public static void listAlimentos() {
		for(Alimento a: ingredientes) {
			System.out.println(a);
		}
	}
	
	public static Alimento find(int id) {
		for(Alimento a: ingredientes) {
			if (id == a.getId()) return a;
		}
		return null;
	}
	@Override
	public String toString() {
		return " id = "+ id+ " proteinas= " + proteinas + " calorias= " + calorias + " peso= " + peso ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(Alimento.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(Alimento.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(Alimento.proteinas))
			return false;
		return true;
	}
	
	
}
