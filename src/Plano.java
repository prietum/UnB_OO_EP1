public class Plano {
	private int id;
	private String nome;
	private float desconto;
	private float custo;
	
	Plano(int id, String nome, float desconto, float custo) {
		this.nome = nome;
		this.id = id;
		this.desconto = desconto;
		this.custo = custo;
	}
	
	int getId(){return this.id;}
	String getNome(){return this.nome;}
	float getDesconto(){return this.desconto;}
	float getCusto(){return this.custo;}
	
	void setId(int id){this.id = id;}
	void setNome(String nome){this.nome = nome;}
	void setDesconto(float desconto){this.desconto = desconto;}
	void setCusto(float custo){this.custo = custo;}
	
	@Override
	public String toString() {
		return String.format(
			"nº%d - \"%s\"/n/tCusto: %.2f\nDesconto: %.2f%%",
			this.id, this.nome, this.custo, this.desconto*100
		);
	}
}