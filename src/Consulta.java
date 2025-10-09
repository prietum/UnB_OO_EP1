import java.time.*;

public class Consulta {
	private Medico med;
	private Paciente pac;
	private LocalDate dat;
	private Status status; //0==agendada, 1==concluida, 2==cancelada
	
	Consulta(Medico med, Paciente pac, LocalDate dat, Status status) {
		this.med = med;
		this.pac = pac;
		this.dat = dat;
		this.status = status;
	}
	
	public Status getStatus(){return this.status;}
	public void setConcluido(){this.status.setConcluido();}
	public void setCancelado(){this.status.setCancelado();}
	
	@Override
	public String toString() {
		return String.format(
			"\tMédico: %s\n\tPaciente: %s\n\tData: %s\n\tStatus: %s",
			this.med.getNome(), this.pac.getNome(), this.dat.toString(), this.status.toString()
		);
	}
}