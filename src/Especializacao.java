//https://www.grupomedcof.com.br/blog/55-especialidades-medicas/

import java.util.HashMap;

enum Especializacao{
	ACUPUNTURA,
	IMUNOLOGIA,
	ANESTESIOLOGIA,
	ANGIOLOGIA,
	CARDIOLOGIA,
	CIR_CARDIO,
	CIR_MAO,
	CIR_CABECA,
	CIR_DIGESTIVO,
	CIR_GERAL,
	CIR_ONCOLOGICA,
	CIR_PEDIATRICA,
	CIR_PLASTICA,
	CIR_TORACICA,
	CIR_VASCULAR,
	CLINICA_MEDICA,
	COLOPROCTOLOGIA,
	DERMATOLOGIA,
	ENDOCRINOLOGIA,
	ENDOSCOPIA,
	GASTROENTEROLOGIA,
	GENETICA,
	GERIATRIA,
	GINECOLOGIA,
	HEMATOLOGIA,
	HOMEOPATIA,
	INFECTOLOGIA,
	MASTOLOGIA,
	MED_EMERGENCIA,
	MED_FAMILIA,
	MED_TRABALHO,
	MED_TREFEGO,
	MED_ESPORTIVA,
	MED_FISICA,
	MED_INTENSIVA,
	MED_LEGAL,
	MED_NUCLEAR,
	MED_PREVENTIVA,
	MED_LABORATORIAL,
	NEFROLOGIA,
	NEUROCIRURGIA,
	NEUROLOGIA,
	NUTROLOGIA,
	OFTALMOLOGIA,
	ONCOLOGIA,
	ORTOPEDIA,
	OTORRINOLARINGOLOGIA,
	PATOLOGIA,
	PEDIATRIA,
	PNEUMOLOGIA,
	PSIQUIATRIA,
	RADIOLOGIA,
	RADIOTERAPIA,
	REUMATOLOGIA,
	UROLOGIA;
	
	HashMap<String, String> n = new HashMap<String, String>();
	do {
		n.put("ACUPUNTURA",				"Acupuntura");
		n.put("IMUNOLOGIA",				"Alergia e imunologia");
		n.put("ANESTESIOLOGIA",			"Anestesiologia");
		n.put("ANGIOLOGIA",				"Angiologia");
		n.put("CARDIOLOGIA",			"Cardiologia");
		n.put("CIR_CARDIO",				"Cirurgia cardiovascular");
		n.put("CIR_MAO",				"Cirurgia da mão");
		n.put("CIR_CABECA",				"Cirurgia de cabeça e pescoço");
		n.put("CIR_DIGESTIVO",			"Cirurgia do aparelho digestivo");
		n.put("CIR_GERAL",				"Cirurgia geral");
		n.put("CIR_ONCOLOGICA",			"Cirurgia oncológica");
		n.put("CIR_PEDIATRICA",			"Cirurgia pediátrica");
		n.put("CIR_PLASTICA",			"Cirurgia plástica");
		n.put("CIR_TORACICA",			"Cirurgia torácica");
		n.put("CIR_VASCULAR",			"Cirurgia vascular");
		n.put("CLINICA_MEDICA",			"Clínica médica");
		n.put("COLOPROCTOLOGIA",		"Coloproctologia");
		n.put("DERMATOLOGIA",			"Dermatologia");
		n.put("ENDOCRINOLOGIA",			"Endocrinologia e metabologia");
		n.put("ENDOSCOPIA",				"Endoscopia");
		n.put("GASTROENTEROLOGIA",		"Gastroenterologia");
		n.put("GENETICA",				"Genética médica");
		n.put("GERIATRIA",				"Geriatria");
		n.put("GINECOLOGIA",			"Ginecologia e obstetrícia");
		n.put("HEMATOLOGIA",			"Hematologia e hemoterapia");
		n.put("HOMEOPATIA",				"Homeopatia");
		n.put("INFECTOLOGIA",			"Infectologia");
		n.put("MASTOLOGIA",				"Mastologia");
		n.put("MED_EMERGENCIA",			"Medicina de emergência");
		n.put("MED_FAMILIA",			"Medicina de família e comunidade");
		n.put("MED_TRABALHO",			"Medicina do trabalho");
		n.put("MED_TREFEGO",			"Medicina do tráfego");
		n.put("MED_ESPORTIVA",			"Medicina esportiva");
		n.put("MED_FISICA",				"Medicina física e reabilitação");
		n.put("MED_INTENSIVA",			"Medicina intensiva");
		n.put("MED_LEGAL",				"Medicina legal e perícia médica");
		n.put("MED_NUCLEAR",			"Medicina nuclear");
		n.put("MED_PREVENTIVA",			"Medicina preventiva e social");
		n.put("MED_LABORATORIAL",		"Nefrologia");
		n.put("NEFROLOGIA",				"Neurocirurgia");
		n.put("NEUROCIRURGIA",			"Neurologia");
		n.put("NEUROLOGIA",				"Nutrologia");
		n.put("NUTROLOGIA",				"Oftalmologia");
		n.put("OFTALMOLOGIA",			"Oncologia clínica");
		n.put("ONCOLOGIA",				"Ortopedia e traumatologia");
		n.put("ORTOPEDIA",				"Otorrinolaringologia");
		n.put("OTORRINOLARINGOLOGIA",	"Patologia");
		n.put("PATOLOGIA",				"Patologia clínica/medicina laboratorial");
		n.put("PEDIATRIA",				"Pediatria");
		n.put("PNEUMOLOGIA",			"Pneumologia");
		n.put("PSIQUIATRIA",			"Psiquiatria");
		n.put("RADIOLOGIA",				"Radiologia e diagnóstico por imagem");
		n.put("RADIOTERAPIA",			"Radioterapia");
		n.put("REUMATOLOGIA",			"Reumatologia");
		n.put("UROLOGIA",				"Urologia");
	}
	
	public String toString() {
		return n.get(name())
	}
}