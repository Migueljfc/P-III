package aula6.ex1;

public class PratoDieta extends Prato {
	private double limite = 0;
	public PratoDieta(String nome,double limite) {
		super(nome);
		this.limite = limite;
	}
	public double getLimite() {
		return limite;
	}
	public boolean addIngredientes(Alimento a) {
		if(limite - a.getCalorias()<0) return false;
		limite -= a.getCalorias();
		return (super.addIngredientes(a));
	}
	
	
	@Override
	public String toString() {
		return "PratoDieta "+ super.toString() ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PratoDieta))
			return false;
		return true;
	}
	
	
	
	

}
