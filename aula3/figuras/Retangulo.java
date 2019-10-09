package aula3.figuras;

public class Retangulo extends Figura{
	private double largura;
	private double altura;

	public Retangulo(Ponto centro, double l, double a) {
		super(centro);
		this.largura = l;
		this.altura = a;
	}
	
	public Retangulo(Retangulo r) {
		this(r.centro(), r.largura, r.altura);
	}

	public Retangulo(double l, double a) {
		this(new Ponto(), l, a);
	}
	
	public Retangulo(double x, double y, double l, double a) {
		this(new Ponto(x, y), l, a);
	}
	
	public double largura() {
		return largura;
	}
	
	public double altura() {
		return altura;
	}
	
	public double area() {
		return largura*altura;
	}
	
	public double perimetro() {
		return (2*altura) + (2*largura);
	}
	
	@Override
	public String toString(){ 
		return "Retangulo";
	}
	public boolean equals(Retangulo r){ 
		return largura == r.largura && altura == r.altura && centro().equals(r.centro());
	}
}
