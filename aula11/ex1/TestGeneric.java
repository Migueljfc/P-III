package aula11.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


import aula10.ex1.*;
import aula5.ex1.*;


public abstract class TestGeneric {
	public static void main(String[] args) {
		ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i, 1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		LinkedList<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		LinkedList<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		LinkedList< Figura > quadList = new LinkedList<Figura>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: "+ sumArea(quadList));
	}
	
	public static double sumArea(LinkedList<? extends Figura> list) {
		double totalArea = 0;
		
		@SuppressWarnings("rawtypes")
		Iterator myIterator = list.iterator();
		while(myIterator.hasNext()) totalArea += ((Figura) myIterator.next()).area();
		
		return totalArea;
	}
	
	public static void printSet(@SuppressWarnings("rawtypes") Iterator myIterator) {
		while(myIterator.hasNext()) System.out.println(myIterator.next());
	}
}

