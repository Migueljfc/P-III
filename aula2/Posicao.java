package aula2;

public class Posicao {
	int x;
	int y;
	
	Posicao(int x,int y){
		this.x=x;
		this.y=y;
	}

	@Override
	public String toString() {
		return "Posicao [x=" + (x+1) + ", y=" + (y+1) + "]";
	}
	
}
