package aula9.ex2;

public class GeladoSimples implements Gelado{
	private String sabor;
	GeladoSimples(String sabor) {
		this.sabor = sabor;
		
	}

	@Override
	public void base(int n) {
		System.out.print("\n"+ n + " bolas de gelado de " + sabor);
	}
	
	 
}
