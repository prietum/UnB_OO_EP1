public class PacienteEspecial extends Paciente {
	Plano plano;
	
	PacienteEspecial(String nome, int cpf, int idade, Plano plano) {
		super(nome, cpf, idade);
		this.plano = plano;
	}
	
	@Override
	public String toString(){
		return String.format(
			"PCT-ESPECIAL\t\t %s\nCPF: %s\nIdade: %i\nPlano: %q",
			this.getNome(),
			this.getStringCpf(),
			this.getIdade(),
			this.plano.getNome()
		);
	}
}