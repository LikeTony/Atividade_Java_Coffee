package lista2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> compras = new ArrayList<String>();
		
		compras.add("Banana");
		compras.add("Amrora");
		compras.add("Melancia");
		compras.add("Pera");
		compras.add("Maçã");
		compras.add("Kiwi");
		
		for(String frutas : compras) {
			System.out.println(frutas);
		}

		compras.remove(2);
		System.out.println("\n");
		
		for(String frutas : compras) {
			System.out.println(frutas);
		}
	}
}
