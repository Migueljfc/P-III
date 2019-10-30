package aula6.ex1;

public class PratoVegetariano extends Prato implements Vegetariano {

	public PratoVegetariano(String nome) {
		super(nome);
		
	}
	
	public boolean addIngredientes(Alimento a) {
		if(!(a instanceof Vegetariano)) return false;
		return (super.addIngredientes(a));
	}
	
	public boolean delIngredientes (Alimento a) {
		if(!(a instanceof Vegetariano)) return false;
		return (super.delIngredientes(a));
	}
	
	@Override
	public String toString() {
		return "PratoVegetariano " + super.toString();
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PratoVegetariano))
			return false;
		return true;
	}
	
	
}
