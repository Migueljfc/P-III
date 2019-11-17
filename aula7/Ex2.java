package aula7;

import java.io.*;
import java.util.Scanner;
import aula7.ex2.*;

public class Ex2 {
    public static void main(String[] args) {
        Bitmap bitmap;

        try {
            bitmap = new Bitmap(getFicheiro()).reverseBytes();
            bitmap.exportRAW();
            Bitmap shrunk = bitmap.shrink();
            shrunk.reverseBytes().exportBMP("FiguraPequena");
            Bitmap horFlip = bitmap.flipHorizontal();
            Bitmap verFlip = bitmap.flipVertical();
            Bitmap horVerFlip = horFlip.flipVertical();
            horFlip.reverseBytes().exportBMP("FiguraHorizontalFlip");
            verFlip.reverseBytes().exportBMP("FiguraVerticalFlip");
            horVerFlip.reverseBytes().exportBMP("FiguraBothFlip");
        } catch (Exception e){
            System.out.println("****** Erro! " + e.getMessage() + " ******");
            System.exit(1);
        }

    }

    public static File getFicheiro() throws IOException {
        Scanner sc = new Scanner(System.in);
        String res = "";
        
        do {
            System.out.print("\nIndique o nome do ficheiro: ");
            res = sc.nextLine();
        } while(res.length() == 0);
        
        File f = new File(res);
        if(!(f.exists() && f.isFile() && f.canRead())) throw new IOException("O Ficheiro não existe ou não pode ser lido!");
        return f;
    }
}