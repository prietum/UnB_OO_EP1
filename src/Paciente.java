public class Paciente extends Pessoa {
	Paciente(String nome, int cpf, int idade) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdade(idade);
	}
	
	@Override
	public String toString(){
		return String.format(
			"PCT-NORMAL\t\t %s\nCPF: %s\nIdade: %i",
			this.getNome(),
			this.getStringCpf(),
			this.getIdade()
		);
	}
}