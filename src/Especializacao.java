//https://www.grupomedcof.com.br/blog/55-especialidades-medicas/

import java.util.HashMap;

enum Especializacao{
	ACUPUNTURA("Acupuntura"),
	IMUNOLOGIA("Alergia e imunologia"),
	ANESTESIOLOGIA("Anestesiologia"),
	ANGIOLOGIA("Angiologia"),
	CARDIOLOGIA("Cardiologia"),
	CIR_CARDIO("Cirurgia cardiovascular"),
	CIR_MAO("Cirurgia da mão"),
	CIR_CABECA("Cirurgia de cabeça e pescoço"),
	CIR_DIGESTIVO("Cirurgia do aparelho digestivo"),
	CIR_GERAL("Cirurgia geral"),
	CIR_ONCOLOGICA("Cirurgia oncológica"),
	CIR_PEDIATRICA("Cirurgia pediátrica"),
	CIR_PLASTICA("Cirurgia plástica"),
	CIR_TORACICA("Cirurgia torácica"),
	CIR_VASCULAR("Cirurgia vascular"),
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
	MED_EMERGENCIA("Medicina de emergência"),
	MED_FAMILIA("Medicina de família e comunidade"),
	MED_TRABALHO("Medicina do trabalho"),
	MED_TREFEGO("Medicina do tráfego"),
	MED_ESPORTIVA("Medicina esportiva"),
	MED_FISICA("Medicina física e reabilitação"),
	MED_INTENSIVA("Medicina intensiva"),
	MED_LEGAL("Medicina legal e perícia médica"),
	MED_NUCLEAR("Medicina nuclear"),
	MED_PREVENTIVA("Medicina preventiva e social"),
	MED_LABORATORIAL("Nefrologia"),
	NEFROLOGIA("Neurocirurgia"),
	NEUROCIRURGIA("Neurologia"),
	NEUROLOGIA("Nutrologia"),
	NUTROLOGIA("Oftalmologia"),
	OFTALMOLOGIA("Oncologia clínica"),
	ONCOLOGIA("Ortopedia e traumatologia"),
	ORTOPEDIA("Otorrinolaringologia"),
	OTORRINOLARINGOLOGIA("Patologia"),
	PATOLOGIA("Patologia clínica/medicina laboratorial"),
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
	
	public String getEsp() {
		return nomeEsp;
	}
}