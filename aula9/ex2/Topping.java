package aula9.ex2;

public class Topping extends GeladoDecorator {
	protected String extras;
	Topping(Gelado j,String extras) {
		super(j);
		this.extras = extras;
	}

	@Override
	public void base(int n) {
		super.base(n);
		System.out.print(" com " + extras);
	}

}
