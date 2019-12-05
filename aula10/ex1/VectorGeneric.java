package aula10.ex1;

import java.util.Iterator;

public class VectorGeneric<T> {
	private T[] vector;
	private int size;
	
	public VectorGeneric() {
		vector = (T[]) new Object[0];
		size = 1;
	}
	
	public boolean addElem(T elem) {
		if(elem == null)
			return false;
		if(size==1) {
			vector[0]=elem;
			return true;
		}else {
			T[] newArray = (T[]) new Object[size+1];
			System.arraycopy(vector, 0, newArray, 0, size);
			vector = newArray;
			vector[size++] = elem;
			return true;
		}
	}
	
	public boolean removeElem(T elem) {
		for(int i=0 ; i<size ; i++) {
			if(vector[i] == elem) {
				size--;
				for(int j=i ; j<size ; j++)
					vector[j] = vector[j+1];
				T[] newArray = (T[])new Object[size];
				System.arraycopy(vector, 0, newArray, 0, size);
				vector = newArray;
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
	
	class VectorIterator implements Iterator<T>{
		private int index;
		
		public VectorIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < size);
		}

		@Override
		public T next() {
			if(hasNext()) {
				T p = vector[index];
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("only "+size+" elements");
		}
		
		
	}
}