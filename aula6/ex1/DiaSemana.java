package aula6.ex1;

public enum DiaSemana {SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO, DOMINGO;
	public static DiaSemana rand() {
		int rand = (int) Math.random()*7;
		DiaSemana d = null;
		for(DiaSemana dia :DiaSemana.values() ) {
			if(dia.ordinal() == rand) {
				d = dia;
			}
		}
		return d;
	}
}
