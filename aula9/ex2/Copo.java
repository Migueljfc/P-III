package aula9.ex2;

public class Copo extends GeladoDecorator{

	Copo(Gelado j){
		super(j);
		
	}

	@Override
	public void base(int n) {
		super.base(n);
		System.out.print(" em copo");
	}
}
		

