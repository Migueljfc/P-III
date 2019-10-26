package aula5.ex3;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia,int mes, int ano){
		if(validarData(dia,mes,ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
		else {
			throw new IllegalArgumentException ("Data inválida");
		}
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
	
	public boolean validarData(int dia,int mes,int ano) {
		
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
