package aula5.ex2;

public class Bicicleta extends Veiculo{
	public Bicicleta (int ano,String cor,int nRodas) {
		super(ano,cor,nRodas);
	}

	@Override
	public String toString() {
		return "BICICLETA "+ " ano = " + super.getAno() + " cor = " + super.getCor() + " nRodas = " + super.getnRodas();
	}
	
}
