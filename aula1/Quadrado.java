package aula1;

public class Quadrado {
	private Ponto p1;
	private Ponto p2;
	
	
	public Quadrado(Ponto p1,Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public double area() {
		return Ponto.distancia(p1,p2) * 2;
		
	}
	public double perimetro() {
		return Ponto.distancia(p1, p2) * 4;
	}
	public String toString() {
		return "Ponto 1: " + p1.x() + "," + p1.y() + "  Ponto 2 " + p2.x() + "," + p2.y() + "  Area: " + area() + "  Perimetro " + perimetro();
	}
}
