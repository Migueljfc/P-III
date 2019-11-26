package aula9.ex3;

import java.util.Iterator;

public class VectorPessoas {
	private Pessoa[] listaPessoas;
	private int size;
	
	public VectorPessoas() {
		listaPessoas = (Pessoa[]) new Pessoa[0];
		size = 0;
	}
	
	public boolean addPessoa(Pessoa p) {
		if(p == null)
			return false;
		if(size==0) {
			listaPessoas[0]=p;
			return true;
		}else {
			Pessoa[] newArray = new Pessoa[size+1];
			System.arraycopy(listaPessoas, 0, newArray, 0, size);
			listaPessoas = newArray;
			listaPessoas[size++] = p;
			return true;
		}
	}
	
	public boolean removePessoa(Pessoa p) {
		for(int i=0 ; i<size ; i++) {
			if(listaPessoas[i] == p) {
				size--;
				for(int j=i ; j<size ; j++)
					listaPessoas[j] = listaPessoas[j+1];
				Pessoa[] newArray = new Pessoa[size];
				System.arraycopy(listaPessoas, 0, newArray, 0, size);
				listaPessoas = newArray;
				return true;
			}
		}
		return false;
	}
	
	public int totalPessoas() {
		return size;
	}
	
	public VectorIterator iterator() {
		return (this).new VectorIterator();
	}
	
	class VectorIterator implements Iterator<Pessoa>{
		private int index;
		
		public VectorIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < size);
		}

		@Override
		public Pessoa next() {
			if(hasNext()) {
				Pessoa p = listaPessoas[index];
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("only "+size+" elements");
		}
	}
}
