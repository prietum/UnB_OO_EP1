import java.time.*;

public class Diagnostico {
	private Paciente pac;
	private Medico med;
	private String conclusao;
	private LocalDate dat;
	private Prescricao[] prescricoes;
	
	Diagnostico(Medico med, Paciente pac, String conclusao, LocalDate dat) {
		this.med = med;
		this.pac = pac;
		this.conclusao = conclusao;
		this.dat = dat;
	}
	
	void addPrescricao(String med, int quant) {this.prescricoes[this.prescricoes.length] = new Prescricao(med, quant);}
	
	String getStringPrescricoes() {
		String blobPrescricoes = "";
		for (int i = 0; i < this.prescricoes.length; i++) {
			blobPrescricoes = blobPrescricoes + String.format("\t\t→%s;\n", this.prescricoes[i].toString());
		}
		return blobPrescricoes;
	}
	
	@Override
	public String toString() {
		return String.format(
			"\tMédico: %s\n\tPaciente: %s\n\t\t%q\n\tPrescrição:\n%s",
			this.med.getNome(), this.pac.getNome(), this.conclusao, this.getStringPrescricoes()
		);
	}
}

class Prescricao {
	private String mdc;
	private int quant;
	
	Prescricao(String mdc, int quant){
		this.mdc = mdc;
		this.quant = quant;
	}
	
	String getMed(){return this.mdc;}
	int getQuant(){return this.quant;}
	
	void setMed(String mdc){this.mdc = mdc;}
	void setQuant(int quant){this.quant = quant;}
	
	@Override
	public String toString() {
		return String.format("%s, %i unidades", this.mdc, this.quant);
	}
}