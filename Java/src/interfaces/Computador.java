package interfaces;

public class Computador implements DispositivoEletronico{

	@Override
	public void ligar() {
		System.out.println("Ligando computador");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligando computador");
		
	}
	
}