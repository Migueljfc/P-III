package aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia{
	protected Tipo oTipo;
	public BicicletaPolicia(int ano,String cor,int nRodas, Tipo tipo) {
		super(ano,cor,nRodas);
		oTipo = tipo;
	}

	@Override
	public Tipo getTipo() {
		return oTipo;
	}

	@Override
	public String toString() {
		return "POLICIA-> " + super.toString();
	}
	

}