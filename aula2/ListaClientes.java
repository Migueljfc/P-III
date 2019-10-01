package aula2;
import java.util.ArrayList;

public class ListaClientes {
	public static ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();
	public static void addPerson(Pessoa pessoa) {
		clientes.add(pessoa);
	}
	
	public static void removePerson(int numSocio) {
		for (Pessoa a: clientes.toArray(new Pessoa[0])) {
			if(a.numSocio() == (numSocio)){
				clientes.remove(a);
				System.out.println("Removida com sucesso");
			}
			else {
				System.out.println("Pessoa não encontrada");
			}
		}
		
	}
	public static void print() {
		if(clientes.size() == 0) {
			System.out.println("Não existem clientes");
		}
		else {
			System.out.println("Nome | CC | Data Nascimento | Nº Socio | Data Inscrição | NºFuncionário/NºMec | Nº Fiscal/Curso");
			for(Pessoa a: clientes) {
				System.out.println(a);
			}
		}	
	}
	public static Pessoa search(int numSocio) {
		for(Pessoa a : clientes) {
			if(a.numSocio()==numSocio) {
				return a ;
			}
		}
		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
