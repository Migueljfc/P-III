package aula1;

public class Retangulo {
	private Ponto p1;
	private Ponto p2;
	private Ponto p3;
	private Ponto p4;
	
	public Retangulo(Ponto p1,Ponto p2,Ponto p3,Ponto p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	public double area() {
		return Ponto.distancia(p1, p2) * Ponto.distancia(p2, p4);
	}
	public double perimetro() {
		return Ponto.distancia(p1, p2) + Ponto.distancia(p2,p3)+ Ponto.distancia(p3, p4)+ Ponto.distancia(p4, p1);
	}
	public String toString() {
		return "Ponto 1: " + p1.x() + "," + p1.y() + "  Ponto 2 " + p2.x() + "," + p2.y() + "  Ponto 3: " + p3.x() + "," + p3.y() + "  Ponto 4: " + p4.x() + "," + p4.x() + "  Area: " + area() + "  Perimetro " + perimetro();
	}
}
