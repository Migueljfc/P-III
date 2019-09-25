package aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(double raio ,Ponto centro){
		this.centro = centro ;
		this.raio = raio;	
	}
	public Circulo(double x,double y, double r) {
		this.centro = new Ponto(x,y);
		this.raio = r;
		
	}
	public double raio() {
		return raio;
	}
	public Ponto centro() {
		return centro;
	}
	public double area() {
		return Math.PI * raio * raio;
	}
	public double perimetro() {
		return 2* Math.PI * raio;
	}
	public String toString() {
		return "Raio: " + raio + "  Centro: " + centro.x() + "," + centro.y() + "  Area: " + area() + "  Perimetro " + perimetro();
	}
	public boolean iguais(Circulo c1,Circulo c2) {
		if (c1.centro() == c2.centro() && c1.raio()== c2.raio()) {
			return true;
		}
		return false;	
	}
	public boolean intersetam(Circulo c1,Circulo c2) {
		double centrox = c1.centro().x()-c2.centro.x();
		double centroy = c1.centro().y()-c2.centro().y();
		double somaRaios = c1.raio()+c2.raio();
		return centrox * centrox + centroy* centroy <= somaRaios * somaRaios;
	}
	
}
