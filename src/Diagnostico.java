import java.time.*;

public class Diagnostico {
	private Paciente pac;
	private Medico med;
	private String conclusao;
	private LocalDate dat;
	private String pres;
	
	Diagnostico(Medico med, Paciente pac, LocalDate dat, String conclusao, String pres) {
		this.med = med;
		this.pac = pac;
		this.dat = dat;
		this.conclusao = conclusao;
		this.pres = pres;
	}
	
	@Override
	public String toString() {
		return String.format(
			"\tMédico: %s\n\tPaciente: %s\n\t\t\"%s\"\n\tPrescrição: %s",
			this.med.getNome(), this.pac.getNome(), this.conclusao, this.pres
		);
	}
}