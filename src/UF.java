import java.util.HashMap;

enum UF {
	RS("Rio Grande do Sul"),
	SC("Santa Catarina"),
	PR("Paraná"),
	SP("São Paulo"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	RJ("Rio de Janeiro"),
	MG("Minas Gerais"),
	ES("Espírito Santos"),
	GO("Goiânia"),
	DF("Distrito Federal"),
	TO("Tocantins"),
	PI("Piauí"),
	BA("Bahia"),
	SE("Sergipe"),
	PB("Paraíba"),
	PE("Pernambuco"),
	RN("Rio Grande do Norte"),
	AL("Alagoas"),
	CE("Ceará"),
	MA("Maranhão"),
	PA("Pará"),
	AM("Amapá"),
	RO("Rondônia"),
	RR("Roraima"),
	AC("Acre"),
	AP("Amapá");
	
	private final String nomeUf;
	private UF(String nomeUf) {
		this.nomeUf = nomeUf;
	}
	
	@Override
	public String toString(){
		return nomeUf;
	}
}