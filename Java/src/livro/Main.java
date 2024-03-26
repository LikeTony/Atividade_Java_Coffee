package livro;

public class Main {
	public static void main(String[] args) {
		int totPag = 12;
		
		Livro livro = new Livro(totPag);
		
		livro.lerPaginas(totPag);
		
	}
}
