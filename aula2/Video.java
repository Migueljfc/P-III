package aula2;

public class Video {
	private int id;
	private String titulo;
	private String categoria;
	private String idade;
	private boolean reservado = false;
	
	public Video(int id,String titulo,String categoria,String idade) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
	}
	public  void checkout() {
		reservado = true;
		
	}
	public void checkin() {
		reservado = false;
	}
	public boolean reservado() {
		return reservado;
	}
	
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCategoria(){
		return categoria;
	}
	public String getIdade() {
		return idade;
	}
	@Override
	public String toString() {
		return  id  +"  "+ titulo + "  " + categoria + "  " + idade + "  " +reservado ;
	}
	
}

