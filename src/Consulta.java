import java.time.*;

public class Consulta {
	private Paciente pac;
	private Medico med;
	private LocalDate dat;
	private Status status; //0==agendada, 1==concluida, 2==cancelada
	
	Consulta(Paciente pac, Medico med, LocalDate dat, Status status) {
		this.pac = pac;
		this.med = med;
		this.dat = dat;
		this.status = status;
	}
	
	void setConcluido(){this.status.setConcluido();}
	void setCancelado(){this.status.setCancelado();}
	
	@Override
	public String toString() {
		return String.format(
			"\tMédico: %s\n\tPaciente: %s\n\tData: %s\n\tStatus: %s",
			this.med.getNome(), this.pac.getNome(), this.dat.toString(), this.status.toString()
		);
	}
}