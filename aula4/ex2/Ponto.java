package aula4.ex2;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Ponto() {
		this.x=0;
		this.y=0;
	}

	public double x() {
		return this.x;
	}
	
	public double y() {
		return this.y;
	}
	
	@Override
	public String toString(){ 
		return "("+x+","+y+")"; 
	}
	public boolean equals(Ponto p) {
		return x == p.x() && y == p.y();
	}
	
}
