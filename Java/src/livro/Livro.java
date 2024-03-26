package livro;

public class Livro {
	private int totalPaginas;
	
	public Livro(int totPag) {
		this.totalPaginas = totPag;
	}
	public void lerPaginas(int paginas) {
		try {
			if (paginas > 1 || paginas < totalPaginas) {
				System.out.println("Livro dentro das especificações");
			}
		}catch(Exception e){
			System.out.println("Livro fora das Especificações");
			System.out.println(e.getMessage());
		}
	}
}
