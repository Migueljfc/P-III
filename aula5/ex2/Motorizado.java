package aula5.ex2;

public class Motorizado extends Veiculo {
	private Combustivel combustivel;
	private int consumo;
	private int potencia;
	public Motorizado(int ano, String matricula, String cor, int nRodas, int velMax, int cc,Combustivel combustivel,int consumo,int potencia) {
		super(ano, matricula, cor, nRodas, velMax, cc);
		this.combustivel = combustivel;
		this.consumo = consumo;
		this.potencia = potencia;
	}
	
	public int getConsumo() {
		return consumo;
	}

	public int getPotencia() {
		return potencia;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	@Override
	public String toString() {
		return super.toString()+" consumo= "+consumo+" potencia= "+potencia + " combustivel= "+combustivel;
	}
	

}
