public class Medico extends Pessoa {
	private Crm crm;
	private Especializacao esp;
	private float custo;
	private Horario hor;
	
	Medico(String nome, Cpf cpf, int idade, Crm crm, Especializacao esp, float custo, Horario hor) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdade(idade);
		
		this.crm = crm;
		this.esp = esp;
		this.custo = custo;
		this.hor = hor;
	}
	
	public Crm getCrm(){return this.crm;}
	public Especializacao getEsp(){return this.esp;}
	public float getCusto(){return this.custo;}
	public Horario getHor(){return this.hor;}
	
	@Override
	public String toString(){
		return String.format(
			"Dr. %s\n\tCPF: %s\n\tIdade: %d\n\tCRM: %s\n\tEsp.: %s\n\tCusto: %s\n\tDisponibilidade: %s",
			this.getNome(), this.getCpf().toString(), this.getIdade(), this.crm.toString(), this.esp.toString(), String.format("R$%.2f", this.custo), this.hor.toString()
		);
	}
}