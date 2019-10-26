package aula5.ex2;

public class CarroPolicia extends Automovel implements Policia {
	private Tipo oTipo;
	public CarroPolicia(int ano, String matricula, String cor, int nRodas, int velMax, int cc,Combustivel combustivel,int consumo,int potencia, Tipo tipo) {
		super(ano, matricula, cor, nRodas, velMax, cc,combustivel,consumo,potencia);
		oTipo = tipo;
	}

	@Override
	public Tipo getTipo() {
		return oTipo ;
	}

	@Override
	public String toString() {
		return "POLICIA-> " + super.toString();
	}
	

}
