package aula1;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double x() {
		return x;
	}
	public double y() {
		return y;
	}
	public static double distancia(Ponto p1, Ponto p2){
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow(p2.y - p1.y, 2));
		
	}
}
