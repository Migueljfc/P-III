package aula2;

public class Funcionario extends Pessoa{
	int nFunc;
	int nFiscal;
	
	public Funcionario(String nome, int cc, Data dataNasc,int numSocio,Data dataInsc,int nFunc,int nFiscal) {
		super(nome,cc,dataNasc,numSocio,dataInsc);
		this.nFiscal = nFiscal;
		this.nFunc = nFunc;
	}
	public int getNFiscal() {
		return nFiscal;
	}
	public int getNFunc() {
		return nFunc;
	}
	public String toString() {
		return super.toString() + " - "+ nFunc + " - " + nFiscal;
	}
}
