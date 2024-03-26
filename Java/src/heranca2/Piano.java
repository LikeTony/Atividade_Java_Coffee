package heranca2;

public class Piano extends InstrumentoMusical{

	@Override
	public void tocar() {
		System.out.println("Tocando Piano");					
	}

	@Override
	public void afinar() {
		System.out.println("Afinando Piano");		
	}

}