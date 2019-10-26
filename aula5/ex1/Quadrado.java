package aula5.ex1;

public class Quadrado extends Figura{
	private double lado;
	
	public Quadrado(Ponto centro, double lado) {
		super(centro);
		this.lado = lado;
	}
	
	public Quadrado(Quadrado q) {
		this(q.centro(), q.lado);
	}
	
	public Quadrado(double lado) {
		this(new Ponto(), lado);
	}
	
	public Quadrado(double x, double y, double lado) {
		this(new Ponto(x, y), lado);
	}

	public double lado(){
		return lado;
	}
	
	public double area() {
		double area = lado * lado;
		return area;
	}
	
	public double perimetro() {
		double perimetro = 4 * lado;
		return perimetro;
	}

	@Override
	public String toString() {
		return "Quadrado de Centro: "+super.centro()+" e Lado: "+lado;	
		}
	public boolean equals(Quadrado q) {
		return lado == q.lado && centro().equals(q.centro());
	}
}
