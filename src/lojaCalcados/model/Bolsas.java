package lojaCalcados.model;

public class Bolsas extends Produto{

	private String bolsas;

	public Bolsas(int id, String nome, int categoria, float preco, String bolsas) {
		super(id, nome, categoria, preco);
		this.bolsas = bolsas;
	}

	public String getFragrancia() {
		return bolsas;
	}

	public void setFragrancia(String bolsas) {
		this.bolsas = bolsas;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Modelo: %s\n", this.bolsas);
	}
}