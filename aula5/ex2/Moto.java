package aula5.ex2;

public class Moto extends Motorizado{
	public Moto (int ano,String matricula,String cor,int nRodas,int velMax,int cc, Combustivel combustivel,int consumo, int potencia) {
		super(ano, matricula, cor,nRodas,velMax,cc,combustivel,consumo,potencia);
	}
	

	@Override
	public String toString() {
		return "MOTO "+super.toString();
	}
	
}
