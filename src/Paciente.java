public class Paciente extends Pessoa{
	Pessoa(String nome, int cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	@Override
	public String toString(){
		return String.format(
			"PCT-NORMAL\t\t %s\nCPF: %s\nIdade: %i",
			this.nome,
			this.getStringCpf(),
			this.idade
		);
	}
}