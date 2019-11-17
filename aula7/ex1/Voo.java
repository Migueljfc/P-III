package aula7.ex1;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

public class Voo implements Comparable{
	private LocalTime departure;
	private String id;
	private Companhia company;
	private Cidade origin;
	private TemporalAmount delay;
	private String obs;
	
	public Voo(LocalTime departure, String id, Companhia company, Cidade origin, TemporalAmount delay) {
		this.departure = departure;
		this.id = id;
		this.company = company;
		this.origin = origin;
		this.delay = delay;
		if(delay != null) this.obs = "Previsto" + departure.plus(delay);
		origin.addFlight();
		company.addAtraso(delay);
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public String getId() {
		return id;
	}

	public Companhia getCompany() {
		return company;
	}

	public Cidade getOrigin() {
		return origin;
	}

	public TemporalAmount getDelay() {
		return delay;
	}

	public String getObs() {
		return obs;
	}

	@Override
	public String toString() {
		if(delay != null)
			return departure + "\t" + id + "\t" + company + "\t" + origin + "\t" + delay + "\t" + obs;
		else
			return departure + "\t" + id + "\t" + company + "\t" + origin;
	}

	@Override
	public int compareTo(Object arg0) {
		if(!(arg0 instanceof Voo)) throw new IllegalArgumentException("INVALID FLIGHT!");
		Voo f = (Voo) arg0;
		return departure.compareTo(f.getDeparture());
	}
}
