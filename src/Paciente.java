public class Paciente extends Pessoa{
	private String[] histConsultas;
	private String[] histInternacoes;
	
	Consultas[] getConsultas() {
		Consultas[] c;
		for (i = 0, i <= this.histConsultas, i++) {
			c[c.length()] = Registro.getConsulta(this.histConsultas[i]);
		}
		return Consultas[];
	}
	
	Internacao[] getInternacoes() {
		Internacoes[] c;
		for (i = 0, i <= this.histInternacoes, i++) {
			c[c.length()] = Registro.getInternacao(this.histInternacoes[i]);
		}
		return Internacoes[];
	}
}