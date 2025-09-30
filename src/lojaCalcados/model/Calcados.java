package lojaCalcados.model;

public class Calcados extends Produto {

	private String anabela;
	
	public Calcados(int id, String nome, int categoria, float preco, String anabela) {
		super(id, nome, categoria, preco);
		this.anabela = anabela;
	}

	public String getAnabela() {
		return anabela;
	}

	public void setTenis(String anabela) {
		this.anabela = anabela;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("Nome Anabela: %s\n", this.anabela);
	}
	
	
}