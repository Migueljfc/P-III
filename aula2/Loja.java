package aula2;
import java.util.ArrayList;
public class Loja {
	public static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	public static void addEmp(Emprestimo e) {
		emprestimos.add(e);
	}
	
	public static void removeEmp(Emprestimo e) {
		emprestimos.remove(e);
	}
	public static Emprestimo search(Video v) {
		for(Emprestimo e : emprestimos) {
			if(e.getVideo()== v ) {
				return e;
			}
		}
		return null;
		
	}	
}
