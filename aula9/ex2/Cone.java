package aula9.ex2;

public class Cone extends GeladoDecorator {
	
	Cone(Gelado j){
		super(j);	
	}
	@Override
	public void base(int n) {
		super.base(n);
		System.out.print(" em cone");
		}
}
	
