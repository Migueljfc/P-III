package aula5.ex1;

import java.util.ArrayList;




public class ColecaoFiguras {
	private ArrayList<Figura> colecao = new ArrayList<Figura>();
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
		areaTotal -= f.area();
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
		ArrayList<Ponto> centros = new ArrayList<>();
		for(Figura a : colecao.toArray(new Figura[0])) {
			centros.add(a.centro());
		}
		return centros.toArray(new Ponto[0]);
	}
	
	
	
}
