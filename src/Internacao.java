import java.util.Optional;

public class Internacao{
	private Paciente pac;
	private Medico med;
	private Periodo per;
	private int status;
	private int id;
	
	Internacao(Paciente pac, Medico med, String d0, Optional<String> d1, int status, int id) {
		this.pac = pac;
		this.med = med;
		this.per = new Periodo(d0, d1);
		this.status = status;
		this.id = id;
	}
	
	void setConcluido(){this.status = 1;}
	void setCancelado(){this.status = 2;}
	
	@Override
	public String toString() {
		return "nº%i\n\tMédico: %s\n\tPaciente: %s\n\t";
	}
}