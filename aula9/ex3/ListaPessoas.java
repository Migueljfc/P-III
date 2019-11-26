package aula9.ex3;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaPessoas {
	private LinkedList<Pessoa> listaPessoas;
	
	public ListaPessoas() {
		listaPessoas = new LinkedList<>();
	}
	
	public void addPessoa(Pessoa p) {
		listaPessoas.add(p);
	}
	
	public void removePessoa(Pessoa p) {
		listaPessoas.remove(p);
	}
	
	
	public int totalPessoas() {
		return listaPessoas.size();
	}
	
	public ListaIterator iterator() {
		return new ListaIterator();
	}
	
	class ListaIterator implements Iterator<Pessoa> {
		private Node<Pessoa> node;
		private int index;
		
		public ListaIterator() {
			node = new Node<>(null, null, listaPessoas.getFirst());
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			return index < listaPessoas.size();
		}
		
		@Override
		public Pessoa next() {
			node  = node.getNext();
			index++;
			return node.getValue();
		}
		
		public boolean hasPrevious() {
			return index > 0;
		}
		
		public Pessoa previous() {
			node = node.getPrevious();
			index--;
			return node.getValue();
		}
		
		@Override
		public void remove() {
			listaPessoas.remove(node.getValue());
		}
	}
}
