package aula2;

public class Estudante extends Pessoa{
	private int nMec;
	private String curso;
	
	public Estudante(String nome, int cc, Data dataNasc,int numSocio,Data dataInsc,int nMec, String curso) {
		super(nome,cc,dataNasc,numSocio,dataInsc);
		this.nMec = nMec;
		this.curso = curso;
		
	}
	public int getNMec() {
		return nMec;
	}
	public String getCurso() {
		return curso;
	}
	public String toString() {
		return super.toString()+" - "+nMec+" - " + curso;
	}
}
