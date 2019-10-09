package aula3.figuras;

public class Circulo extends Figura{
	private double raio;
	
	public Circulo(Ponto centro, double raio) {
		super(centro);
		this.raio = raio;
	}
	
	public Circulo(Circulo c1) {
		this(c1.centro(),c1.raio);
	}
	
	public Circulo(double raio) {
		this(new Ponto(), raio);
	}
	
	public Circulo(double x, double y, double raio) {
		this(new Ponto(x, y), raio);
	}

	public double raio() {
		return raio;
	}
	
	public double area() { 
		double area = Math.PI*Math.pow(raio, 2); 
		return area;
	}

	public double perimetro() { 
		double perimetro = 2*Math.PI*raio; 
		return perimetro;
	}

	@Override
	public String toString() {
		return "Circulo";
	}
	public boolean equals(Circulo c) {
		return raio == c.raio();
	}
	
	
}
