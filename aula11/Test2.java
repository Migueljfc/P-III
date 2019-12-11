package aula11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import aula5.ex1.Figura;
import aula5.ex1.*;

public class Test2 {

	public static void main(String[] args) {
		List<Figura> list = new ArrayList<>();
		list.add(new Quadrado(1));
		list.add(new Quadrado(3));	
		list.add(new Retangulo(1,2));
		list.add(new Retangulo(2,1));
		System.out.println("Maior figura: " + maiorFiguraJ7(list));
		System.out.println("Maior perimetro: " + maiorPerimetroFiguraJ7(list));
		System.out.println("Soma total das areas: " + areaTotalJ8(list));
		System.out.println("Soma total das areas dos retangulos: " + areaTotalJ8(list,"Retangulo"));

	}
	
	private static Figura maiorFiguraJ7(List<Figura> figs){
        return figs.stream().max(Figura::compareTo).get();
    }
	private static Figura maiorPerimetroFiguraJ7(List<Figura> figs) {
		return figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura f1, Figura f2) {
				double dif = f1.perimetro()-f2.perimetro();
				if(dif < 0) {
					return -1;
				}
				if(dif > 0) {
					return 1;
					
				}
				return 0;
			}
		
		}).get();
	}
  private static double areaTotalJ8(List<Figura>figs) {
	  return figs.stream().mapToDouble(f-> f.area()).sum();
  }
  private static double areaTotalJ8(List<Figura> figs,String subtipoNome) {
	  return figs.stream().filter(f-> f.getClass().getSimpleName().equals(subtipoNome)).mapToDouble(f->f.area()).sum();
  }

}
