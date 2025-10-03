import java.util.HashMap;
import java.util.Optional;

public class UI {
	
	String getStringCpf(int cpf){
		String str = Integer(cpf).toString();
		return String.format(
			"%s.%s.%s-%s", 
			str.substring(1,3), str.substring(4,6), str.substring(7,9), str.substring(10,11));
		}
		
	void dspClear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	void dspMenu() {
		System.out.printf(String.format(
			"Sistema Hospitalar - Menu Principal\n\n" +
			"1. Atendimento\n" +
			"2. Administração\n" +
			"3. Registro\n"
			));
	}
	
	void dspAtend() {
		System.out.println(String.format(
			"Sistema Hospitalar - Atendimento\n\n" +
			"1. Cadastrar paciente\n" +
			"2. Cadastrar médico\n" +
			"3. Cadastrar consulta\n" +
			"4. Cadastrar internação\n\n" +
			"5. Cadastrar diagnóstico\n\n" +
			
			"6. Atualizar consulta\n" +
			"7. Atualizar internação\n\n" +
		
			"8. Remover paciente\n" +
			"9. Remover médico\n"
			));
	}
	
	void dspAdmin() {
		System.out.println(String.format(
			"Sistema Hospitalar - Administração\n\n" +
			"1. Gerir quartos\n" +
			"2. Gerir planos\n"
			));
	}
	
	void dspCadPac(Optional<String> optNome, Optional<int> optCpf, Optional<int> optIdade, Optional<boolean> optHasPlano, Optional<Plano> optPlano) {
		String blobNome = "Nome: ...\n";
		String blobCpf = "CPF: ...\n";
		String blobIdade = "Idade: ...\n";
		String blobPlano = "Plano: ...\n";
		
		optNome.isPresent(nome -> blobNome = String.format("Nome: %s\n", nome));
		optCpf.isPresent(cpf -> blobCpf = String.format("CPF: %s\n", cpf));
		optIdade.isPresent(idade -> blobIdade = String.format("Idade: %s\n", idade));
		if (optHasPlano.isPresent()){
			if (optHasPlano.get()) {
				optHasPlano.isPresent(planoId -> blobPlano = String.format("Plano: %s\n", Registro.getPlano(planoId).getNome));
			} else {
				blobPlano = "Plano: nenhum\n"
			}
			
		}
		
		System.out.println(String.format("Sistema Hospitalar - Cadastro de Paciente\n\n" + blobNome + blobCpf + blobIdade + blobPlano);
	}
	
	void dspCadMed(
		Optional<String> optNome, 
		Optional<int> optCpf, 
		Optional<int> optIdade, 
		Optional<Crm> optCrm,
		Optional<Especialidade> optEsp,
		Optional<float> optFloat,
		Optional<Horario> optHor
		) {
			
		String blobNome = "Nome: ...\n";
		String blobCpf = "CPF: ...\n";
		String blobIdade = "Idade: ...\n";
		String blobCrm = "CRM: ...\n";
		String blobEsp = "Especialidade: ...\n";
		String blobCusto = "Custo: ...\n";
		String blobHor = "Horário: ...\n";
		
		optNome.isPresent(nome -> blobNome = String.format("Nome: %s\n", nome));
		optCpf.isPresent(cpf -> blobCpf = String.format("CPF: %s\n", cpf));
		optIdade.isPresent(idade -> blobIdade = String.format("Idade: %s\n", idade));
		optCrm.isPresent(crm -> blobCrm = String.format("CRM: %s\n", crm));
		optEsp.isPresent(esp -> blobEsp = String.format("Especialidade: %s\n", esp));
		optCusto.isPresent(custo -> blobCusto = String.format("Custo: %s\n", custo));
		optHor.isPresent(hor -> blobHor = String.format("Horário: %s\n", hor));
		
		System.out.println("Sistema Hospitalar - Cadastro de Médico\n\n" + blobNome + blobCpf + blobIdade + blobCrm + blobEsp + optFloat + optHor);
	}
	
	void dspCons(
		Optional<Paciente> optPac, 
		Optional<Medico> optMed, 
		Optional<int> optIdade, 
		Optional<Crm> optCrm,
		Optional<Especialidade> optEsp,
		Optional<float> optFloat,
		Optional<Horario> optHor
		) {
			
		String blobNome = "Nome: ...\n";
		String blobCpf = "CPF: ...\n";
		String blobIdade = "Idade: ...\n";
		String blobCrm = "CRM: ...\n";
		String blobEsp = "Especialidade: ...\n";
		String blobCusto = "Custo: ...\n";
		String blobHor = "Horário: ...\n";
		
		optNome.isPresent(nome -> blobNome = String.format("Nome: %s\n", nome));
		optCpf.isPresent(cpf -> blobCpf = String.format("CPF: %s\n", cpf));
		optIdade.isPresent(idade -> blobIdade = String.format("Idade: %s\n", idade));
		optCrm.isPresent(crm -> blobCrm = String.format("CRM: %s\n", crm));
		optEsp.isPresent(esp -> blobEsp = String.format("Especialidade: %s\n", esp));
		optCusto.isPresent(custo -> blobCusto = String.format("Custo: %s\n", custo));
		optHor.isPresent(hor -> blobHor = String.format("Horário: %s\n", hor));
		
		System.out.println("Sistema Hospitalar - Cadastro de Médico\n\n" + blobNome + blobCpf + blobIdade + blobCrm + blobEsp + optFloat + optHor);
	}
	
	void dspReg() {
		String blobTitulo = "Sistema Hospitalar - Registro\n\n";
		System.out.println(Registro.toString());
	}
}