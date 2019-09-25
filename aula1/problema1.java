package aula1;
import java.util.Scanner;
public class problema1 {
	public static void main (String[] args) {
		String frase;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma frase");
		frase = sc.nextLine();
		int countNum = 0;
		int countUpper = 0;
		int countLow = 0;
		int countws = 0;
		String novaFrase = "";
		//boolean Upper = false;
		//boolean Low = false;
		
		
		for(int i=0;i < frase.length();i++) {
			if(Character.isDigit(frase.charAt(i))){
				countNum++;
			}
			if(Character.isUpperCase(frase.charAt(i))) {
				countUpper ++;
			}
			if(Character.isLowerCase(frase.charAt(i))) {
				countLow ++;
			}
			if(Character.isWhitespace(frase.charAt(i))) {
				countws++;
			}
				
		}
		if(countUpper == frase.length() - countws - countNum) {
			//Upper = true;
			System.out.println("A frase só tem maiusculas");
			
		}
		if(countLow == frase.length() - countws - countNum) {
			//Low = true;
			System.out.println("A frase so tem minusculas");
		}
		String[] array = frase.split(" ",countws + 1);
		System.out.printf("Existem %2d caracteres numéricos \n",countNum);
		System.out.println("A frase tem " + (countws + 1) + " palavras:");
        for (String a : array) { 
            System.out.println(a);
            for(int i = 0;i < a.length()-1;i+=2) {
            	novaFrase += String.valueOf(a.charAt(i+1)) + String.valueOf(a.charAt(i));
            	
            }
            
            if(a.length() % 2 != 0) {
            	novaFrase += a.charAt(a.length()-1);
            }
            novaFrase += " ";
         }
        System.out.println("Nova frase com os caracteres trocados: ");
        System.out.println(novaFrase);
        sc.close();
        }
        
}

	

