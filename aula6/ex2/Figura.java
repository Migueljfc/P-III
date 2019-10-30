package aula6.ex2;
public abstract class Figura implements Comparable<Figura>{
private Ponto centro;
	
	public Figura(Ponto centro) {
		this.centro = centro;
	}
	public abstract double area();
	public abstract double perimetro();
	
	public Ponto centro() {return centro; }

	@Override
	public String toString() { return "Figura"; }
	
	public int compareTo(Figura f) {
		if(f == null) {
			throw new NullPointerException("Figura não existe");
		}
		return (int) (this.area()-f.area());
	}
}

