package aula3.Estudantes;

import aula1.Data;

public class Fellow extends Student{
	private int bolsa;

	public Fellow(String nome, int cc, Data dataNasc, Data dInsc) {
		super(nome, cc, dataNasc, dInsc);
	}

	public Fellow(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
	}

	public int getBolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}

	@Override
	public String toString() {
		return super.toString()+", Bolsa: "+bolsa;
	}
	
	
}
