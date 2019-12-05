package aula10;

import java.util.Iterator;

import aula10.ex2.BinarySearchTree;

public class Test2 {
	 public static void main(String[] args){
	        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
	        for(int i = 0;i < 10 ; i++) {
	        	tree.insert(i);
	        }
	        printSet(tree.iterator());
	        
	        System.out.println(tree.contains(1)); // true
	        tree.remove(1);
	        System.out.println(tree.contains(1) + "\n"); // false
	        
	        printSet(tree.iterator());
	        }
	        public static <T> void printSet(Iterator<T> i){
	            while(i.hasNext()) {
	            	System.out.println(i.next());
	            }
	            System.out.println();
	            
	        }
	       
	    

}
