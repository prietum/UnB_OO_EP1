public class PacienteEspecial extends Paciente {
	Plano plano;
	
	PacienteEspecial(String nome, Cpf cpf, int idade, Plano plano) {
		super(nome, cpf, idade);
		this.plano = plano;
	}
	
	@Override
	public String toString(){
		return String.format(
			"%s (especial)\nCPF: %s\nIdade: %d\nPlano: \"%s\"",
			this.getNome(),
			this.getCpf().toString(),
			this.getIdade(),
			this.plano.getNome()
		);
	}
}