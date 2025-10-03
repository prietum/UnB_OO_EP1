public class Medico extends Pessoa {
	Crm crm;
	Especializacao esp;
	double custo;
	Horario hor;
	
	@Override
	public String toString(){
		return String.format(
			"MÉDICO\t\t%s\nCPF: %s\nIdade: %i\nCRM: %i\nEsp.: %s\nCusto: %s\nDisponibilidade: %s",
			this.nome, this.getStringCpf(), this.idade, this.crm.toString(), this.esp.toString(), String.format("R$%.2f", this.custo), this.hor.toString()
		);
	}
}