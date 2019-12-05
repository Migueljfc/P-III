package aula10.ex1;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaGeneric<T> {
	private LinkedList<T> list;
	
	public ListaGeneric() {
		list = new LinkedList<T>();
	}
	
	public void addElem(T elem) {
		list.add(elem);
	}
	
	public void removeElem(T elem) {
		list.remove(elem);
	}
	
	public int totalPessoas() {
		return list.size();
	}
	
	public ListaIterator iterator() {
		return new ListaIterator();
	}
	
	class ListaIterator implements Iterator<T> {
		private int index;
		
		public ListaIterator() {
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			return index < list.size();
		}
		
		@Override
		public T next() {
			index++;
			return list.get(index);
		}
		
		public boolean hasPrevious() {
			return index > 0;
		}
		
		@Override
		public void remove() {
			list.remove(index);
		}
	}

}