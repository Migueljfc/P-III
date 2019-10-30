package aula6.ex1;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Ementa {
	private String nome;
	private String local;
	private static Hashtable<DiaSemana,LinkedList<Prato>> pratos = new Hashtable<DiaSemana,LinkedList<Prato>>(); 
	public Ementa(String nome,String local) {
		this.nome = nome;
		this.local = local;
	}
	
	public String getNome() {
		return nome;
	}
	public String getLocal() {
		return local;
	}

	public Prato[] getPratoPorDia(int d) {
		LinkedList<Prato> lista = pratos.get(DiaSemana.values()[d]);
		Prato[] temp = new Prato[lista.size()];
		int i = 0;
		for(Prato p: lista.toArray(new Prato[0])){
			temp[i++] = p;
		}
		return temp;
	} 
	public static void addPrato(Prato p,DiaSemana dia) {
		if(pratos.containsKey(dia)) {
			 pratos.get(dia).add(p);
		}
		else {
			LinkedList<Prato> temp = new LinkedList<>();
			temp.add(p);
			pratos.put(dia, temp);
		}	
	}
	@SuppressWarnings("unlikely-arg-type")
	public static void dellPrato(Prato p) {
		if(pratos.containsKey(p)) {
			pratos.remove(p);
		}
		else {
			System.err.println("Prato nao existe");
		}
	}
	public static Prato find(String nome) {
		@SuppressWarnings("unchecked")
		Prato[] arrayPratos = ((List<Prato>) pratos).toArray(new Prato[0]);
		for(Prato v : arrayPratos) {
			if (nome.equals(v.getNome())) return v;
		}
		return null;
	}
	

	@Override
	public String toString() {
		String s = "";
		DiaSemana[] sorted = pratos.keySet().toArray(new DiaSemana[0]);
		Arrays.sort(sorted);
		for(DiaSemana dia: sorted) {
			LinkedList<Prato> novaLista = pratos.get(dia);
			for(Prato p: novaLista.toArray(new Prato[0])) {
				s+= p.toString()+" dia= "+dia+"\n";
			}
		}
		return s;
	}
	
}
