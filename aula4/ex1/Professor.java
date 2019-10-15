package aula4.ex1;

import java.util.Calendar;

import aula1.Data;
import aula1.Pessoa;

public class Professor extends Pessoa{
	private static int n = 1;
	private final int nfunc;
	private final Data dataAdmissao;
	public Professor(String nome, int cc, Data dataNasc) {
		super(nome,cc,dataNasc);
		this.nfunc = n++;
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int month = today.get(Calendar.MONTH) + 1;
		int year = today.get(Calendar.YEAR);
		this.dataAdmissao = new Data(day, month, year);
	}
	@Override
	public String toString() {
		return "Representante: "+ nome + " , BI: "+ cc + ", Nascido na Data: "+ dataNasc + ", NMEC: "+ nfunc + ", Admitido em Data: " + dataAdmissao ;
	}
	
	
}
