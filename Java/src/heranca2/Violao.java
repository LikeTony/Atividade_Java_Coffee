package heranca2;

public class Violao extends InstrumentoMusical{

	@Override
	public void tocar() {
		System.out.println("Tocando Violão");					
	}

	@Override
	public void afinar() {
		System.out.println("Afinando Violão");		
	}

}
