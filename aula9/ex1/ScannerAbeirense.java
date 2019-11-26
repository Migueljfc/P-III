package aula9.ex1;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable{
	private Scanner sc;
	
	public ScannerAbeirense(String s) {
		sc = new Scanner(s);
	}
	public ScannerAbeirense(File f) {
		try {
			sc = new Scanner(f);
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public String nextLine() {
		String s = "";
		String next = next();
		while(!next.equals("\n")) {
			s += next;
			next = next();
		}
		return s;
	}
	@Override
	public void close() throws IOException {
		sc.close();
		
	}

	@Override
	public boolean hasNext() {
		if(sc.hasNext()) return true;
		return false;
	}

	@Override
	public String next() {
		String s = sc.next();
		s = s.replace("v", "b");
		s = s.replace("V", "B");
		return s;
	}
	
}
