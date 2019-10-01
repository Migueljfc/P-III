package aula2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class problema2 {
	static int size ;
	static char [][] matriz;
	static List<String> palavras;
	static List<String> sopa;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		matriz = new char[80][80];
		File f = new File(args[0]);
		if(verify(f,args[0])) {
			Scanner scf = new Scanner(f);
			String firstline = scf.nextLine();
			size = firstline.length();
			int j = 0;
			for(int i = 0;i<size;i++) {
				matriz[j][i] = firstline.charAt(i);
			}
			j++;
			palavras = new ArrayList<>(size);
			while(scf.hasNextLine()) {
				String line = scf.nextLine();
				if(!line.contains(",")) { //palavras separadas por virgula vão diretamente para a matriz
					for(int i = 0;i<size;i++) {
						matriz[j][i] = line.charAt(i);
					}
					j++;						}
					else {
					for(String palavra : line.split(", ")) {
						palavras.add(palavra); // as restantes palavras são adicionadas ao ArrayList para serem analisadas 
					}
				}
			}
			sopa = new LinkedList<>();
			
			for(int i=0;i<size;i++) {
				for(int k=0;k<size;k++) {
					search(k,i);
				}
			}
			for(String s: sopa) {
				System.out.println(s);
			}
			scf.close();
		}
		else {
			System.exit(0);
		}
				
	}
	public static boolean verify(File nameFile, String file){
		if(!nameFile.exists()){
			System.out.printf("ERROR: input name %s is not a file\n", file);
			return false;
		}else if(nameFile.isDirectory()){
			System.out.printf("ERROR: input name %s is a directory\n", file);
			return false;
		}else if(!nameFile.canRead()){
			System.out.printf("ERROR: input name %s can't be read\n", file);
			return false;
		}
		return true;
	}
	public static void search(int x,int y) {
			for(String palavra : palavras)
			{
				if (matriz[y][x] == palavra.charAt(0))
				{
					Posicao now = new Posicao(x, y);
					
					if(x+palavra.length()-1<size) 
					{
						String dir = "right";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x+palavra.length(),y))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(x-palavra.length()+1>=0) 
					{ 
						String dir = "left";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x-palavra.length(), y))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(y+palavra.length()-1<size) 
					{
						String dir = "down";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x, y+palavra.length()))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(y-palavra.length()+1>=0) 
					{
						String dir = "up";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x, y-palavra.length()))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(x+palavra.length()-1<size && y+palavra.length()-1<size) 
					{
						String dir = "downright";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x+palavra.length(), y+palavra.length()))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(x+palavra.length()-1<size && y-palavra.length()+1>=0) 
					{
						String dir = "upright";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x+palavra.length(), y-palavra.length()))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(x-palavra.length()+1>=0 && y+palavra.length()-1<size) 
					{
						String dir = "downleft";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x-palavra.length(), y+palavra.length()))) 
						{
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
					
					if(x-palavra.length()+1>=0 && y-palavra.length()+1>=0) 
					{
						String dir = "upleft";
						if(encontrarPalavras(palavra, dir, now,new Posicao(x-palavra.length(), y-palavra.length()))) {
							sopa.add(palavra + "\t" + now + "\t" + dir);
						}
					}
				}
			}
		}
	public static boolean encontrarPalavras(String palavra,String dir,Posicao limiteInferior,Posicao limiteSuperior) {
		int xx = 0;
		int yy = 0;
		
		int x = limiteInferior.x;
		int y = limiteInferior.y;
		
		if(dir.contains("up")) {
			yy = -1;
		}else if(dir.contains("down")) {
			yy = 1;
		}
		
		if(dir.contains("left")) {
			xx = -1;
		}else if(dir.contains("right")) {
			xx = 1;
		}
		
		String temporaria = "";
		
		for(int i = 0; i < palavra.length(); i++) {
			temporaria += matriz[y][x];
			x += xx;
			y += yy;
		}
		
		return temporaria.equals(palavra);
	}
	
}

