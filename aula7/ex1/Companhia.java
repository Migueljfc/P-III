package aula7.ex1;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

public class Companhia implements Comparable {
	private final String nome;
	private final String sigla;
	private LocalTime totalAtraso;
	private int nVoos;
	
	public Companhia(String nome,String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		totalAtraso = LocalTime.MIN;
		nVoos = 0;
	}
	
	public void addAtraso(TemporalAmount atraso) {
		totalAtraso.plus(atraso);
		nVoos++;
	}
	
	public LocalTime getMedia() {
		int hora = totalAtraso.getHour();
		int min = totalAtraso.getMinute();
		int mediaHora = hora/nVoos;
		int mediaMin = min/nVoos;
		LocalTime media = LocalTime.of(mediaHora, mediaMin);
		return media;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	
	public LocalTime getTotalAtraso() {
		return totalAtraso;
	}

	public int getnVoos() {
		return nVoos;
	}
	
	
	
	@Override
	public int compareTo(Object other) {
		if(!(other instanceof Companhia)) throw new IllegalArgumentException("Objeto não é uma companhia");
		Companhia c = (Companhia) other;
		return getMedia().compareTo(c.getMedia());
		
	}
	
	

}
