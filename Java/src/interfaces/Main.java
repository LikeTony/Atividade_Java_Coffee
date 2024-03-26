package interfaces;

public class Main {
	public static void main(String[] args) {
		
		Televisao tv = new Televisao();
		Computador pc = new Computador();
		
		tv.ligar();
		tv.desligar();
		
		pc.ligar();
		pc.desligar();
	}
}
