package aula5.ex2;

import java.util.ArrayList;


public class VeiculosList {
	public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	public static boolean add(Veiculo v) {
		if(veiculos.contains(v)) {
			return false;
		}
		return veiculos.add(v);
	}
	public static boolean del(Veiculo v) {
		if(!veiculos.contains(v)) {
			return false;
		}
		return veiculos.remove(v);
	}
	public static void print() {
		for(Veiculo v :veiculos){
			System.out.println(v);
		}
	}
	public static void ordenar() {
		Veiculo [] array;
		array = (Veiculo[]) veiculos.toArray(new Veiculo[veiculos.size()]);
		UtilCompare.sortArray(array);
		for(int i =0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
