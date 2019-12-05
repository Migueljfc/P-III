package aula10.ex2;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Stack;
public class BinarySearchTree<T extends Comparable <? super T>> implements Iterable<T>{
	private static class BSTNode<T>{
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		
		BSTNode(T theElement){
			element = theElement;
			left = right = null;
		}
	}
	
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
		
	}
	
	public void insert(T value) {
		root = insert(value,root);
		numNodes++;
	}
	
	public void remove(T value) {
		root = remove(value,root);
		numNodes--;
	}
	
	public boolean contains(T value) {
		return find(value,root) != null;
	}
	public BSTNode<T> insert(T value,BSTNode<T> node){
		if(node == null) {
			return new BSTNode<>(value);
		}
		int compare = value.compareTo(node.element);
		if(compare < 0) {
			node.left = insert(value,node.left);
		}
		if(compare > 0) {
			node.right = insert(value,node.right);
		}
		return node;
	}
	private void insert(BSTNode<T> value, BSTNode <T> node ){
		if(node == null) {
			root = value;
		}
		int compare = value.element.compareTo(node.element);
		if (compare < 0) {
			if(node.left == null) {
				node.left = value;
			}else {
				insert(value,node.left);
			}
		}else if(compare > 0) {
			if(node.right == null) {
				node.right =value;
			}
			else{
				insert(value,node.left);
			}
		}
	
		
	}
	
	private BSTNode <T> remove(T value, BSTNode <T> node){
		if(node == null) {
			return null;
		}
		
		if(node.right != null && node.right.element.compareTo(value) == 0) {
			BSTNode<T>right = node.right.right;
			BSTNode<T>left = node.right.left;
			node.right = null;
			if(right != null) {
				insert(right,root);
			}
			if(left != null) {
				insert(left,root);
			}
		}
		else if(node.left != null && node.left.element.compareTo(value)== 0) {
			BSTNode<T> right = node.left.right;
			BSTNode<T> left = node.left.right;
			node.left = null;
			if(right != null) {
				insert(right,root);
			}
			if(left != null) {
				insert(left,root);
			}
		}
		else {
			int compare = node.element.compareTo(value);
			if(compare < 0) {
				node.right = remove(value,node.right);
			}
			if(compare > 0) {
				node.left = remove(value,node.left);
			}
		}
		return node;
	}
	
	public BSTNode<T> find(T value,BSTNode<T> node){
		if(node == null) {
			return null;
		}
		int compare = node.element.compareTo(value);
		if(compare > 0) {
			return find(value,node.left);
		}
		if(compare < 0) {
			return find(value,node.right);
		}
		if(compare == 0) {
			return node;
		}
		return null;
		
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<E> implements Iterator<E>{
		Stack<BSTNode<E>> stack;
		public BSTIterator(BSTNode<E> root) {
			stack = new Stack<>();
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
		}
		@Override
		public boolean hasNext() {
			
			return !stack.isEmpty();
		}
		@Override
		public E next() {
			BSTNode<E> node = stack.pop();
			E top = node.element;
			if(node.right != null) {
				node = node.right;
				while(node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return top;
		}
		
	}
	
	
}
