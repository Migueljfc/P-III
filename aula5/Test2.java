package aula5;
import aula5.ex2.*;
public class Test2 {

	public static void main(String[] args) {
		Combustivel gasolina = Combustivel.gasolina;
		Combustivel gasoleo = Combustivel.gasoleo;
		Combustivel gas = Combustivel.gas;
		//Automoveis
		Veiculo a1 = new Automovel(2000,"12-MT-13","preto",4,240,1000,gasolina,7, 250);
		Veiculo a2 = new Automovel(2010,"14-CD-89","vermelho",4,250,1000,gasoleo,8, 260);
		Veiculo a3 = new Automovel(2001,"17-CA-47","azul",4,250,1000,gas,6, 270);
		System.out.println(VeiculosList.add(a1)); //true
		System.out.println(VeiculosList.add(a2)); //true
		System.out.println(VeiculosList.add(a3)); //true
		//Motos
		Veiculo m1 = new Moto(2019,"14-CD-89","vermelho",2,300,1000,gasolina,4, 290);
		System.out.println(VeiculosList.add(m1)); //true
		System.out.println(VeiculosList.add(m1)); //false
		//Bicicleta
		Veiculo b1 = new Bicicleta(2018,"amarelo",2);
		Veiculo b2 = new Bicicleta(2015,"verde",2);
		System.out.println(VeiculosList.add(b1)); //true
		System.out.println(VeiculosList.del(b1)); //true
		System.out.println(VeiculosList.del(b2));//false
		System.out.println(VeiculosList.add(b2)); //true
		//Veiculos Policia
		Tipo inem = Tipo.INEM;
		Tipo bombeiros = Tipo.Bombeiros;
		Tipo gnr = Tipo.GNR;
		Tipo psp = Tipo.PSP;
		Tipo pj = Tipo.PJ;
		
		Veiculo p1 = new MotoPolicia(2019,"18-AD-58","vermelho",2,400,1000,gasolina,4, 300,psp);
		Veiculo p2 = new MotoPolicia(2017,"52-DF-85","branco",2,200,1200,gasolina,4,400,gnr);
		Veiculo p3 = new CarroPolicia(2015,"18-LD-9","vermelho",4,250,1000,gasoleo,8, 260,inem);
		Veiculo p4 = new BicicletaPolicia(2016,"roxo",2,pj);
		Veiculo p5 = new BicicletaPolicia(1999,"azul",2,bombeiros);
		System.out.println(VeiculosList.add(p1)); //true
		System.out.println(VeiculosList.add(p2)); //true
		System.out.println(VeiculosList.add(p3)); //true
		System.out.println(VeiculosList.add(p4)); //true
		System.out.println(VeiculosList.add(p5)); //true
		
		System.out.println("\nLista de veiculos");
		VeiculosList.print();
		
		System.out.println("\nLista de veiculos ordenada");
		VeiculosList.ordenar();
	
	}

}
