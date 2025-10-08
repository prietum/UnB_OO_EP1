import java.util.Optional;

public class Internacao{
	private Paciente pac;
	private Medico med;
	private Periodo per;
	private Quarto qua;;
	private Status status;
	
	Internacao(Paciente pac, Medico med, Periodo per, Quarto qua, Status status) {
		this.pac = pac;
		this.med = med;
		this.per = per;
		this.qua = qua;
		this.status = status;
	}
	
	void setConcluido(){this.status.setConcluido();}
	void setCancelado(){this.status.setCancelado();}
	
	@Override
	public String toString() {
		return String.format("\tMédico: %s\n\tPaciente: %s\n\tPeríodo: %s\n\tQuarto: nº%d\n\tStatus: %s",
			this.med.getNome(), this.pac.getNome(), this.per.toString(), this.qua.getId(), this.status.toString()
		);
	}
}