package aula9.ex2;

public abstract class GeladoDecorator implements Gelado{
	protected Gelado j;
	protected int n;
	GeladoDecorator(Gelado j){ this.j = j;}
	public void base (int n) {j.base(n);}
	
}
