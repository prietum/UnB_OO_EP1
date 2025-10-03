public class PacienteEspecial extends Paciente {
	Plano plano;
	
	PacienteEspecial(String nome, int cpf, int idade, Plano plano) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.plano = plano;
	}
	
	@Override
	public String toString(){
		return String.format(
			"PCT-ESPECIAL\t\t %s\nCPF: %s\nIdade: %i\nPlano: %q",
			this.nome,
			this.getStringCpf(),
			this.idade,
			this.plano.getNome()
		);
	}
}