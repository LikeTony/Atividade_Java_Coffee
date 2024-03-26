package interfaces;

public class Televisao implements DispositivoEletronico{

	@Override
	public void ligar() {
		System.out.println("Televisão ligando");
		
	}

	@Override
	public void desligar() {
		System.out.println("Televisão desligando");
		
	}
	
}
