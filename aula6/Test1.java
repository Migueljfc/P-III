package aula6;
import aula6.ex1.*;
public class Test1 {
	public static void main(String[] args) {
		Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");
		Prato[] pratos = new Prato[10];
		for (int i=0; i < pratos.length; i++){
			pratos[i] = randPrato(i);
			int cnt = 0;
			while (cnt <2){ // Adicionar 2 Ingredientes a cada Prato
				Alimento aux = randAlimento();
				if (pratos[i].addIngredientes(aux))
					cnt++;
				else
					System.out.println("ERRO: Não é possivel adicionar '" + aux + "' ao -> " + pratos[i]);
			}
			//System.out.println(DiaSemana.rand());
			Ementa.addPrato(pratos[i], DiaSemana.rand()); // Dia Aleatório
		}
	System.out.println("\n"+ ementa);
	}
	// Retorna um Alimento Aleatoriamente
	public static Alimento randAlimento() {
		switch ((int) (Math.random() * 4)) {
		default:
		case 0:
			return new Carne(300, 22.3, 345.3, Variedade.frango);
		case 1:
			return new Peixe(200, 31.3, 25.3, Tipo.congelado);
		case 2:
			return new Legume(150, 21.3, 22.4, "Couve Flor");
		case 3:
			return new Cereal(110, 19.3, 32.4, "Milho");
		}
	}
	// Retorna um Tipo de Prato Aleatoriamente
	public static Prato randPrato(int i) {
		switch ((int) (Math.random() * 3)) {
			default:
			case 0:
				return new Prato("Prato N." + i);
			case 1:
				return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
			case 2:
				return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
		}
	}
}