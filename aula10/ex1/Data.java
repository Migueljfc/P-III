package aula10.ex1;

import java.util.Calendar;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	private static Calendar calendar = Calendar.getInstance();
	
	public Data(int dia,int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int dia() {
		return dia;
	}
	public int mes() {
		return mes;
	}
	public int ano() {
		return ano;
	}
	
	public static Data today() {
		int dia,mes,ano;
		
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH);
		ano = calendar.get(Calendar.YEAR);
		
		return new Data(dia,mes,ano);
	}
	
	public boolean validarData() {
		
		if (dia < 1 || dia > 31 || ano < 0 || ano > 2019 || mes < 1 || mes > 12) {
			return false;
		}
		if(mes == 2) {
			if(bissexto(ano)) {
				return dia <= 29;
			}
			else return ano <= 28;
		}
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return dia <= 30;
		}
		return true;		
	}
	public static boolean bissexto(int ano) {
		return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
	}
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
