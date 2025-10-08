//https://www.grupomedcof.com.br/blog/55-especialidades-medicas/

import java.util.HashMap;

enum Especializacao{
	ACUPUNTURA("Acupuntura"),
	IMUNOLOGIA("Alergia e imunologia"),
	ANESTESIOLOGIA("Anestesiologia"),
	ANGIOLOGIA("Angiologia"),
	CARDIOLOGIA("Cardiologia"),
	CLINICA_MEDICA("Clínica médica"),
	COLOPROCTOLOGIA("Coloproctologia"),
	DERMATOLOGIA("Dermatologia"),
	ENDOCRINOLOGIA("Endocrinologia e metabologia"),
	ENDOSCOPIA("Endoscopia"),
	GASTROENTEROLOGIA("Gastroenterologia"),
	GENETICA("Genética médica"),
	GERIATRIA("Geriatria"),
	GINECOLOGIA("Ginecologia e obstetrícia"),
	HEMATOLOGIA("Hematologia e hemoterapia"),
	HOMEOPATIA("Homeopatia"),
	INFECTOLOGIA("Infectologia"),
	MASTOLOGIA("Mastologia"),
	NEUROLOGIA("Neurologia"),
	NUTROLOGIA("Nutrologia"),
	OFTALMOLOGIA("Oftalmologia"),
	ONCOLOGIA("Oncologia clínica"),
	ORTOPEDIA("Ortopedia e traumatologia"),
	OTORRINOLARINGOLOGIA("Otorrinolaringologia"),
	PATOLOGIA("Patologia"),
	PEDIATRIA("Pediatria"),
	PNEUMOLOGIA("Pneumologia"),
	PSIQUIATRIA("Psiquiatria"),
	RADIOLOGIA("Radiologia e diagnóstico por imagem"),
	RADIOTERAPIA("Radioterapia"),
	REUMATOLOGIA("Reumatologia"),
	UROLOGIA("Urologia");
	
	private final String nomeEsp;
	private Especializacao(String nomeEsp) {
		this.nomeEsp = nomeEsp;
	}
	
	@Override
	public String toString() {
		return nomeEsp;
	}
}