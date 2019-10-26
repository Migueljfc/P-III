package aula5.ex2;

public abstract class Veiculo implements Comparable<Veiculo>{
	private static int count = 0;
	private int id;
	private int ano;
	private String matricula;
	private String cor;
	private int nRodas;
	private int velMax;
	private int cc;
	
	public Veiculo(int ano,String matricula,String cor,int nRodas,int velMax,int cc) {
		this.id = count ++;
		this.ano = ano;
		this.matricula = matricula;
		this.cor = cor ;
		this.nRodas = nRodas;
		this.velMax = velMax;
		this.cc = cc;
	}
	public Veiculo(int ano,String cor,int nRodas) {
		this.id = count++;
		this.ano = ano;
		this.cor = cor;
		this.nRodas = nRodas;
	}
	
		
	public int getId() {
		return id;
	}

	public int getAno() {
		return ano;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCor() {
		return cor;
	}

	public int getnRodas() {
		return nRodas;
	}

	public int getVelMax() {
		return velMax;
	}

	public int getCc() {
		return cc;
	}
	
	public int compareTo(Veiculo v) {
		if(ano > v.getAno()) {
			return 1;
		}
		if(ano < v.getAno()) {
			return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "id=" + id + ", ano=" + ano + ", matricula=" + matricula + ", cor=" + cor + ", nRodas=" + nRodas
				+ ", velMax=" + velMax + ", cc=" + cc ;
	}
	
	
	
	
	
	
}
