package lojaCalcados.model;

public class Calcados extends Produto {

	private String calcados;
	
	public Calcados(int id, String nome, int categoria, float preco, String calcados) {
		super(id, nome, categoria, preco);
		this.calcados = calcados;
	}

	public String getCalcados() {
		return calcados;
	}

	public void setCalcados(String calcados) {
		this.calcados = calcados;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("Nome Calçado: %s\n", this.calcados);
	}
	
	
}