package aula6.ex1;

public class Carne extends Alimento {
	private Variedade variety;
	public Carne (double proteinas,double calorias,double peso,Variedade variety) {
		super(proteinas, calorias, peso);
		this.variety =  variety;
	}
	public Variedade getVariedade() {
		return variety;
	}
	@Override
	public String toString() {
		return "Carne variedade= " + variety + super.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((variety == null) ? 0 : variety.hashCode());
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
		Carne other = (Carne) obj;
		if (variety != other.variety)
			return false;
		return true;
	}
	
	
	
	
	
}
