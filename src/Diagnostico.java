import java.time;

public class Diagnostico() {
	private String conclusao;
	private Prescricao[] prescricoes;
	//private data em que o documento foi feito aki
	private Medico med;
	private Paciente pac;
	private int id;
	
	Diagnostico(Medico med, Paciente pac, String conclusao) {
		this.med = med;
		this.pac = pac;
		this.conclusao = conclusao;
	}
	
	void addPrescricao(String med, int quant) {prescricoes[prescricoes.length()] = new Prescricao(med, quant);}
	
	String getStringPrescricoes() {
		String blobPrescricoes = "";
		for (i = 0; i < this.prescricoes.length(); i++) {
			blobPrescricoes = blobPrescricoes + String.format("\t\t→%s;\n", this.prescricoes[i].toString());
		}
		return blobPrescricoes
	}
	
	@Override
	public String toString() {
		return String.format(
			"#%i\n\tMédico: %s\n\tPaciente: %s\n\t\t%q\n\tPrescrição:\n%s",
			this.id, this.med.getNome(), this.pac.getNome(), this.conclusao, this.getStringPrescricoes()
		);
	}
}

private class Prescricao() {
	private String mdc;
	private int quant;
	
	Prescricao(mdc, quant){
		this.mdc = mdc;
		this.quant = quant;
	}
	
	String getMed(){return this.mdc;}
	void setMed(mdc){this.mdc = mdc;}
	String getQuant(){return this.quant;}
	void setQuant(quant){this.quant = quant;}
	
	@Override
	public String toString() {
		return String.format("%s, %i unidades", this.mdc, this.quant);
	}
}