package heranca2;

public class Main {

	public static void main(String[] args) {
		Piano piano = new Piano();
		Violao violao = new Violao();
		
		piano.afinar();
		piano.tocar();
		
		violao.afinar();
		violao.tocar();
	}
}
