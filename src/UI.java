import java.util.HashMap;
import java.util.Optional;

public class UI {
	
	void dspClear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	void dspMenu() {
		System.out.printf(String.format(
			"Sistema Hospitalar - Menu Principal\n\n" +
			"1. Cadastro\n" +
			"2. Ver registro\n"
			));
	}
	
	void dspCad() {
		System.out.println(String.format(
			"Sistema Hospitalar - Cadastro\n\n" +
			"1. Cadastrar paciente\n" +
			"2. Cadastrar médico\n"
			));
	}
	
	////
	private Optional<String> dspCadPac_nome = new Optional.empty();
	private Optional<Integer> dspCadPac_cpf = new Optional.empty();
	private Optional<Integer> dspCadPac_idade = new Optional.empty();
	private Optional<Integer> dspCadPac_planoId = new Optional.empty();
	
	void set_dspCadPac_nome(String nome){this.dspCadPac_nome = new Optional.of(nome);}
	void set_dspCadPac_cpf(Integer cpf){this.dspCadPac_cpf = new Optional.of(cpf);}
	void set_dspCadPac_idade(Integer idade){this.dspCadPac_idade = new Optional.of(idade);}
	void set_dspCadPac_planoId(Integer planoId){this.dspCadPac_planoId = new Optional.of(planoId);}
	
	void clear_dspCadPac(){
		dspCadPac_nome = new Optional.empty();
		dspCadPac_cpf = new Optional.empty();
		dspCadPac_idade = new Optional.empty();
		dspCadPac_plano = new Optional.empty();
	}
	
	void dspCadPac() {
		String blobNome = "Nome: ...";
		String blobCpf = "CPF: ...";
		String blobIdade = "Idade: ...";
		String blobPlano = "Plano: ...";
		
		this.dspCadPac_nome.isPresent(nome -> blobNome = String.format("Nome: %s", nome));
		this.dspCadPac_cpf.isPresent(cpf -> blobCpf = String.format("CPF: %s", cpf));
		this.dspCadPac_idade.isPresent(idade -> blobIdade = String.format("Idade: %s", idade));
		this.dspCadPac_planoId.isPresent(planoId -> blobPlano = String.format("Plano: %s", Registro.getPlano(planoId).getNome));
		
		System.out.println(String.format("Sistema Hospitalar - Cadastro de Paciente\n\n%s\n%s\n%s\n%s\n%s\n", blobNome, blobCpf, blobIdade, blobPlano));
	}
	
	////
	void dspReg(HashMap<int, Paciente> pacientes) {
		String blobTitulo = "Sistema Hospitalar - Registro\n\n";
		String blobPacientes = "";
		String blobRegistro = "";
		
		for (Paciente paciente : pacientes.values()) {
			blobPacientes = blobPacientes + String.format("→%i/t%i/t%s\n");
		}
		
		blobRegistro = blobTitulo + blobPacientes;
		
		System.out.println(blobRegistro);
	}
}