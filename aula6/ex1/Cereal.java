package aula6.ex1;

public class Cereal extends Alimento implements Vegetariano {
	private String nome;
	public Cereal(double proteinas, double calorias, double peso,String nome) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Cereal nome= " + nome +  super.toString() ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cereal other = (Cereal) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	

}
