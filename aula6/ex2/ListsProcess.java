package aula6.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface ListsProcess {
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> tmp = new ArrayList<T>();
		for(T t : list) if(p.test(t)) tmp.add(t);
		return tmp;
	}

}
