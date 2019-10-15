package aula4.ex2;

import java.util.ArrayList;
import java.util.List;



public class ColecaoFiguras {
	private List<Figura> colecao = new ArrayList<Figura>();
	private double maxArea;
	private double areaTotal;
	
	public ColecaoFiguras(double maxArea) {
		this.maxArea = maxArea;
		this.areaTotal = 0;
		
	}
	public boolean addFigura(Figura f) {
		if((areaTotal + f.area()> maxArea)|| colecao.contains(f)) {
			return false;
		}
		
		areaTotal += f.area();
		return colecao.add(f);
	}
	
	public boolean delFigura(Figura f) {
		if(!colecao.contains(f)) {
			return false;
		}
		colecao.remove(f);
		return true;
	}
	
	public double areaTotal() {
		return areaTotal;
	}
	
	public boolean exists(Figura f) {
		for(Figura a : colecao.toArray(new Figura[0])) {
			if(a != null) {
				return true;
			}
			
		}
		return false;
	}
	@Override
	public String toString() {
		return "maxArea=" + maxArea + ", areaTotal=" + areaTotal ;
	}
	
	public Figura[] getFiguras() {
		return colecao.toArray(new Figura[0]);
	}
	
	public Ponto[] getCentros() {
		List<Ponto> centros = new ArrayList<>();
		for(Figura a : colecao.toArray(new Figura[0])) {
			centros.add(a.centro());
		}
		return centros.toArray(new Ponto[0]);
	}
	
	
	
}
