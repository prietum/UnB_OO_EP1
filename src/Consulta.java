import java.time;

public class Consulta {
	private Paciente pac;
	private Medico med;
	private Horario hor;
	private int status; //0==agendada, 1==concluida, 2==cancelada
	private int id;
	
	Consulta(Paciente pac, Medico med, Horario hor, int status, int id) {
		this.pac = paciente;
		this.med = med;
		this.hor = hor;
		this.status = status;
		this.id = id;
	}
	
	@Override
	public String toString() {
		String blobStatus;
		switch (this.status){
			case: 0
			blobStatus = "Agendada";break;
			case: 1
			blobStatus = "Concluída";break;
			case: 2
			blobStatus = "Cancelada";break;
			default:
			blobStatus = "???";break;
		}
		
		return String.format(
			"#%i\n\tMédico: %s\n\tPaciente: %s\n\tHorário: %s\n\tStatus: %s",
			this.id, this.med.getNome(), this.pac.getNome(), this.hor.toString(), blobStatus
		);
	}
}