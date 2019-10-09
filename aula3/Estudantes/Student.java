package aula3.Estudantes;

import aula1.Pessoa;

import java.util.Calendar;

import aula1.Data;

public class Student extends Pessoa{
	static int currentMec = 100;
	private int nMec;
	private Data dInsc;
	
	public Student(String nome, int cc, Data dataNasc, Data dInsc) {
		super(nome, cc, dataNasc);
		this.nMec = currentMec++;
		this.dInsc = dInsc;
	}

	public Student(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		this.nMec = currentMec++;
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int month = today.get(Calendar.MONTH) + 1;
		int year = today.get(Calendar.YEAR);
		this.dInsc = new Data(day, month, year);
	}

	public int getnMec() {
		return nMec;
	}

	public Data getdInsc() {
		return dInsc;
	}

	@Override
	public String toString() {
		return super.toString()+", NMec:"+nMec+", inscrito em Data:"+dInsc;
	}
}
