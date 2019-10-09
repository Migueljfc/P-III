package aula3.exer3;

public class Veiculo {
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private int peso;
	private char carta;
	private Pessoa condutor;
	
	
	Veiculo(int cilindrada, int potencia, int lotacao, int peso,Pessoa condutor,char carta) {
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.lotacao = lotacao;
		this.peso = peso;
		this.condutor = condutor;
		this.carta = carta;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public char getCarta() {
		return carta;
	}

	public Pessoa getCondutor() {
		return condutor;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getLotacao() {
		return lotacao;
	}

	public int getPeso() {
		return peso;
	}
	
	

	@Override
	public String toString() {
		return "cilindrada=" + cilindrada + ", potencia=" + potencia + ", lotacao=" + lotacao + ", peso="
				+ peso + ", carta=" + carta + ", condutor=" + condutor ;
	}
	
	
	
	
}
