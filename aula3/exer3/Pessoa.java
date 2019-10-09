package aula3.exer3;

public class Pessoa {
	private String nome;
	private int cc;
	private char[] tipoDeCarta;
	
	public Pessoa(String nome, int cc, char[] tipoDeCarta) {
		this.nome = nome;
		this.cc = cc;
		this.tipoDeCarta = tipoDeCarta;
	}
	public String getNome() {
		return nome;
	}
	public int getCc() {
		return cc;
	}
	
	public String getTipoDeCarta() {
		return cartaToString(tipoDeCarta);
	}
	public String cartaToString(char[] carta) {
		String s = "";
		for(int i = 0;i<=carta.length;i++) {
			s = String.valueOf(carta[i]);
			s += ",";
		}
		return s;
	}
	
}
