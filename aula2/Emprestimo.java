package aula2;

public class Emprestimo{
	
	private Pessoa pessoa;
	private Data dataEmp;
	private Video video;
	private Data dataEnt;
	public Emprestimo(Pessoa pessoa,Video video,Data dataEmp,Data dataEnt) {
		this.pessoa = pessoa;
		this.video = video;
		this.dataEmp = dataEmp;
		this.dataEnt = dataEnt;
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Video getVideo() {
		return video;
	}

	public Data getDataEmp() {
		return dataEmp;
	}

	public Data getDataEnt() {
		return dataEnt;
	}

}


