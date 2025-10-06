abstract class Pessoa {
	private String nome;
	private Cpf cpf;
	private int idade;
	
	boolean verifyIdade(int a) {
		return a >= 0 && a <= 120;
	}
	
	void setNome(String nome)	{this.nome = nome;}
	void setCpf(Cpf cpf)		{this.cpf = cpf;}
	void setIdade(int idade)	{this.idade = idade;}
	
	String getNome()			{return nome;}
	Cpf getCpf()				{return cpf;}
	int getIdade()				{return idade;}
}