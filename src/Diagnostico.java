public class Diagnostico() {
	private String conclusao;
	private Prescricao[] prescricoes;
	
	Diagnostico(String conclusao) {
		this.conclusao = conclusao;
	}
	
	String getConclusao(){return this.conclusao;}
	void setConclusao(conclusao){this.conclusao = conclusao;}
	
	void addPrescricao(String med, int quant) {
		prescricoes[prescricoes.length()] = new Prescricao(med, quant);
	}
	Prescricao[] getPrescricoes(){
		return this.prescricoes;
	}
}

private class Prescricao() {
	private String med;
	private int quant;
	
	Prescricao(med, quant){
		this.med = med;
		this.quant = quant;
	}
	
	String getMed(){return this.med;}
	void setMed(med){this.med = med;}
	String getQuant(){return this.quant;}
	void setQuant(quant){this.quant = quant;}
}