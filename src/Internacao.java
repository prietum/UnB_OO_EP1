import java.util.Optional;

public class Internacao{
	private Paciente pac;
	private Medico med;
	private Periodo per;
	private Status status;
	
	Internacao(Paciente pac, Medico med, String d0, Optional<String> d1, Status status) {
		this.pac = pac;
		this.med = med;
		this.per = new Periodo(d0, d1);
		this.status = status;
	}
	
	void setConcluido(){this.status.setConcluido();}
	void setCancelado(){this.status.setCancelado();}
	
	@Override
	public String toString() {
		return String.format("\tMédico: %s\n\tPaciente: %s\n\tPeríodo: %s\n\tStatus: %s\n\t",
			this.med.getNome(), this.pac.getNome(), this.per.toString(), this.status.toString()
		);
	}
}