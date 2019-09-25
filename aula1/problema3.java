package aula1;

import java.util.Scanner;

public class problema3 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int escolha;
		do {
			System.out.println();
			System.out.println(" ____________________________________________");
			System.out.println("|            Figuras Geométricas             |");
			System.out.println("|____________________________________________|");
			System.out.println("|   1-> Circulo                              |");
			System.out.println("|   2-> Quadrado                             |");
			System.out.println("|   3-> Retangulo                            |");
			System.out.println("|   4-> Sair                                 |");
			System.out.println("|____________________________________________|");
			escolha = sc.nextInt();
			switch(escolha) {
			case 1:
				System.out.println("Digite a abcissa do centro");
				double x1 = sc.nextDouble();
				System.out.println("Digite a ordenada do centro");
				double y1 = sc.nextDouble();
				System.out.println("Digite o raio");
				double r = sc.nextDouble();
				Circulo circle = new Circulo(r,new Ponto(x1,y1));
				System.out.println(circle.toString());
			break;
			case 2:
				System.out.println("Digite a abcissa do ponto1");
				double x2 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto1");
				double y2 = sc.nextDouble();
				System.out.println("Digite a abcissa do ponto2");
				double x3 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto2");
				double y3 = sc.nextDouble();
				Quadrado square = new Quadrado(new Ponto(x2,y2),new Ponto(x3,y3));
				System.out.println(square.toString());
			break;
			case 3:
				System.out.println("Digite a abcissa do ponto1");
				double x4 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto1");
				double y4 = sc.nextDouble();
				System.out.println("Digite a abcissa do ponto2");
				double x5 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto2");
				double y5 = sc.nextDouble();
				System.out.println("Digite a abcissa do ponto3");
				double x6 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto3");
				double y6 = sc.nextDouble();
				System.out.println("Digite a abcissa do ponto4");
				double x7 = sc.nextDouble();
				System.out.println("Digite a ordenada do ponto4");
				double y7 = sc.nextDouble();
				Retangulo rectangle = new Retangulo(new Ponto(x4,y4),new Ponto(x5,y5), new Ponto(x6,y6),new Ponto(x7,y7));
				System.out.println(rectangle.toString());
			break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Escolha inválida");
			}
		}while(escolha != 4);
		
	
	}
}
