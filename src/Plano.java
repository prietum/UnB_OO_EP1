public class Plano() {
	private String nome;
	private int id;
	private double desconto;
	private double custo;
	
	Plano(String nome, int id, double desconto, double custo) {
		this.nome = nome;
		this.id = id;
		this.desconto = desconto;
		this.custo = custo;
	}
	
	String getNome(){return this.nome;}
	int getId(){return this.id;}
	double getDesconto(){return this.desconto;}
	double getCusto(){return this.custo;}
	
	void setNome(String nome){this.nome = nome;}
	void setId(String id){this.id = id;}
	void setDesconto(String desconto){this.desconto = desconto;}
	void setCusto(String custo){this.custo = custo;}
}