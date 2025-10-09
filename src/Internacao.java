import java.util.Optional;

public class Internacao{
	private Medico med;
	private Paciente pac;
	private Periodo per;
	private Quarto qua;;
	private Status status;
	
	Internacao(Medico med, Paciente pac, Periodo per, Quarto qua, Status status) {
		this.med = med;
		this.pac = pac;
		this.per = per;
		this.qua = qua;
		this.status = status;
	}
	
	public Status getStatus(){return this.status;}
	public void setConcluido(){this.status.setConcluido();}
	public void setCancelado(){this.status.setCancelado();}
	
	@Override
	public String toString() {
		return String.format(
			"\tMédico: %s\n\tPaciente: %s\n\tPeríodo: %s\n\tQuarto: nº%d\n\tStatus: %s",
			this.med.getNome(), this.pac.getNome(), this.per.toString(), this.qua.getId(), this.status.toString()
		);
	}
}