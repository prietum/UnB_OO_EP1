abstract class Pessoa{
	private String nome;
	private int cpf;
	private int idade;
	
	Paciente(String nome, int cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	boolean verifyNome(String a) {
		return a.length() > 0;
	}
	
	boolean verifyCpf(int a) {
		return Integer.toString(a).length() == 11;
	}
	
	boolean verifyIdade(int a) {
		return a >= 0 && a <= 120;
	}
	
	String getNome(){return nome}
	void setNome(String nome){this.nome = nome}
	String getCpf(){return cpf}
	void setCpf(String cpf){this.cpf = cpf}
	String getIdade(){return idade}
	void setIdade(String idade){this.idade = idade}
}