public class Plano {
	private String nome;
	private int id;
	private float desconto;
	private float custo;
	
	Plano(String nome, int id, float desconto, float custo) {
		this.nome = nome;
		this.id = id;
		this.desconto = desconto;
		this.custo = custo;
	}
	
	String getNome(){return this.nome;}
	int getId(){return this.id;}
	float getDesconto(){return this.desconto;}
	float getCusto(){return this.custo;}
	
	void setNome(String nome){this.nome = nome;}
	void setId(int id){this.id = id;}
	void setDesconto(float desconto){this.desconto = desconto;}
	void setCusto(float custo){this.custo = custo;}
	
	@Override
	public String toString() {
		return String.format(
			"nº%i - %q/n/tCusto: %.2f\nDesconto: %.2f%%",
			this.id, this.nome, this.custo, this.desconto*100
		);
	}
}