package aula7.ex1;


public class Cidade implements Comparable{
	private String name;
	private int nFlights;
	
	public Cidade(String city) {
		this.name = city;
		this.nFlights = 0;
	}

	public String getName() {
		return name;
	}

	public int getnFlights() {
		return nFlights;
	}
	
	public void addFlight() {
		nFlights ++;
	}


	@Override
	public int compareTo(Object arg0) {
		if(!(arg0 instanceof Cidade)) throw new IllegalArgumentException("INVALID CITY!");
		Cidade c = (Cidade) arg0;
		return c.nFlights - nFlights;
	}

	@Override
	public String toString() {
		return name + "\t" + nFlights;
	}
	
}