package aula3;

import aula1.Data;
import aula3.Estudantes.*;

public class Test1 {
	public static void main(String args[]) {
		Student est = new Student ("Andreia", 9855678, new Data(18, 7, 1974));
		Fellow bls = new Fellow ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
		
		System.out.println("Estudente: " + est.nome());
		System.out.println(est);
		System.out.println("Bolseiro: " + bls.nome() + ", NMec: " + bls.getnMec() + ", Bolsa: " + bls.getBolsa());
		System.out.println(bls);
	}
}
