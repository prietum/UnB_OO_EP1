import java.util.HashMap;

enum UF {
	RS,
	SC,
	PR,
	SP,
	MS,
	MG,
	RJ,
	MG,
	ES,
	GO,
	DF,
	TO,
	PI,
	BA,
	SE,
	PB,
	PE,
	RN,
	AL,
	CE,
	MA,
	PA,
	AM,
	RO,
	RR,
	AC,
	AP;
	
	HashMap<String, String> n = new HashMap<String, String>();
	do {
		n.put("RS", "Rio Grande do Sul");
		n.put("SC", "Santa Catarina");
		n.put("PR", "Paraná");
		n.put("SP", "São Paulo");
		n.put("MS", "Mato Grosso do Sul");
		n.put("MG", "Mato Grosso");
		n.put("RJ", "Rio de Janeiro");
		n.put("MG", "Minas Gerais");
		n.put("ES", "Espírito Santos");
		n.put("GO", "Goiânia");
		n.put("DF", "Distrito Federal");
		n.put("TO", "Tocantins");
		n.put("PI", "Piauí");
		n.put("BA", "Bahia");
		n.put("SE", "Sergipe");
		n.put("PB", "Paraíba");
		n.put("PE", "Pernambuco");
		n.put("RN", "Rio Grande do Norte");
		n.put("AL", "Alagoas");
		n.put("CE", "Ceará");
		n.put("MA", "Maranhão");
		n.put("PA", "Pará");
		n.put("AM", "Amapá");
		n.put("RO", "Rondônia");
		n.put("RR", "Roraima");
		n.put("AC", "Acre");
		n.put("AP", "Amapá");
	}
	
	@Override
	String toString(){
		return n.get(name());
	}
}