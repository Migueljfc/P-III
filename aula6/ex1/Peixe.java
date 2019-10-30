package aula6.ex1;

public class Peixe extends Alimento {
	Tipo tipo;
	public Peixe(double proteinas,double calorias,double peso, Tipo tipo) {
		super(proteinas,calorias,peso);
		this.tipo = tipo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	@Override
	public String toString() {
		return "Peixe tipo= " + tipo + super.toString() ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peixe other = (Peixe) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
	
	
}
