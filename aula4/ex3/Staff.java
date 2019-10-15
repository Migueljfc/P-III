package aula4.ex3;

import aula1.Data;

public class Staff extends Person {
	private int nStaff;
	private int nif;

	public Staff(String name, int nCC, Data birthday, int nStaff, int nif) {
		super(name, nCC, birthday);
		this.nStaff = nStaff;
		this.nif = nif;
	}

	public int nStaff() {
		return nStaff;
	}

	public int nif() {
		return nif;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Staff Number: "+nStaff+", NIF: "+nif;
	}
}
