package aula5.ex3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
private ArrayList<Pessoa> db;
	
	public Agenda() {
		db = new ArrayList<Pessoa>();
	}
	
	private Agenda(ArrayList<Pessoa> db) {
		this.db = db;
	}
	
	public boolean containsPessoa(int cc) {
		for(Pessoa p : db) {
			if(p.cc() == cc) return true;
		} return false;
	}
	
	public boolean isEmpty() {
		return db.isEmpty();
	}
	
	public void addPessoa(String nome, int cc, Data data) {
		db.add(new Pessoa(nome,cc,data));
	}
	
	public boolean removePessoa(int cc) {
		for(Pessoa p : db) {
			if(p.cc() == cc) {
				db.remove(p);
				return true;
			}
		} return false;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> getDB(){
		return (ArrayList<Pessoa>) db.clone();
	}
	
	public void changeOrder(int escolha) {
		switch (escolha) {
        case 1:
            Collections.sort(db, new Comparator<Pessoa>() {
                @Override
                public int compare(Pessoa p1, Pessoa p2) {
                return p1.nome().compareTo(p2.nome());
                }
            });
            break;
        case 2:
            Collections.sort(db, new Comparator<Pessoa>() {
                @Override
                public int compare(Pessoa p1, Pessoa p2) {
                return p1.cc() - p2.cc();
                }
            });
            break;
        case 3:
            Collections.sort(db, new Comparator<Pessoa>() {
                @Override
                public int compare(Pessoa p1, Pessoa p2) {
                    if(p1.dataNasc().ano() != p2.dataNasc().ano()) return p1.dataNasc().ano() - p2.dataNasc().ano();
                    if(p1.dataNasc().mes() != p2.dataNasc().mes()) return p1.dataNasc().mes() - p2.dataNasc().mes();
                    return p1.dataNasc().dia() - p2.dataNasc().dia();
                }
            });
            break;
        case 4:
            Collections.reverse(db);
            break;
        default:
            throw new IllegalArgumentException();
        }
	}
	
	@SuppressWarnings("unchecked")
	public Agenda clone() {
		return new Agenda((ArrayList<Pessoa>) db.clone());
	}

}