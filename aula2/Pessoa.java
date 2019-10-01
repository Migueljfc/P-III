package aula2;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	public int numSocio;
	private Data dataInsc;
	
	public Pessoa(String nome, int cc, Data dataNasc,int numSocio,Data dataInsc) {
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
		this.dataInsc = dataInsc;
		this.numSocio = numSocio;
	}
	
	public String nome() {
		return nome;
	}
	public int cc() {
		return cc;
	}
	public Data dataNasc() {
		return dataNasc;	
	}
	public int numSocio() {
		return numSocio;
	}
	public Data dataInsc() {
		return dataInsc;
	}
	
	public String toString() {
		return nome + " - " + cc + " - " + dataNasc + " - " + numSocio + " - " + dataInsc;
	}
	
	
}
