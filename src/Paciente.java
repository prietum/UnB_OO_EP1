public class Paciente extends Pessoa {
	Paciente(String nome, Cpf cpf, int idade) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdade(idade);
	}
	
	@Override
	public String toString(){
		return String.format(
			"PCT-NORMAL\t%s\n\tCPF: %s\n\tIdade: %d",
			this.getNome(),
			this.getCpf().toString(),
			this.getIdade()
		);
	}
}