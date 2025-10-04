import java.util.HashMap;
import java.util.Optional;

public class UI {
	public void dspClear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void dspMenu() {
		System.out.printf(String.format(
			"Sistema Hospitalar - Menu Principal\n\n" +
			"1. Atendimento\n" +
			"2. Administração\n" +
			"3. Registro\n"
			));
	}
	
	public void dspAtend() {
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
	
	public void dspAdmin() {
		System.out.println(String.format(
			"Sistema Hospitalar - Administração\n\n" +
			"1. Gerir quartos\n" +
			"2. Gerir planos\n"
			));
	}
	
	public void dspCadPac(
		Optional<String> optNome, 
		Optional<String> optCpf, 
		Optional<String> optIdade, 
		Optional<String> optHasPlano, 
		Optional<String> optPlanoNome
		) {
			
		// elegante 💃
		String blobNome = String.format("Nome: %s\n", optNome.orElse("..."));
		String blobCpf = String.format("CPF: %s\n", optCpf.orElse("..."));
		String blobIdade = String.format("Idade: %s\n", optIdade.orElse("..."));
		String blobPlano;
		
		if (optHasPlano.isPresent()) {
			blobPlano = String.format("Plano: %s\n", optPlanoNome.orElse("nenhum"));
		} else {
			blobPlano = "Plano: ...\n";
		}
		
		System.out.println(String.format("Sistema Hospitalar - Cadastro de Paciente\n\n" + blobNome + blobCpf + blobIdade + blobPlano));
	}
	
	public void dspCadMed(
		Optional<String> optNome, 
		Optional<String> optCpf, 
		Optional<String> optIdade, 
		Optional<String> optCrm,
		Optional<String> optEsp,
		Optional<String> optCusto,
		Optional<String> optHor
		) {
			
		String blobNome = String.format("Nome: %s\n", optNome.orElse("..."));
		String blobCpf = String.format("CPF: %s\n", optCpf.orElse("..."));
		String blobIdade = String.format("Idade: %s\n", optIdade.orElse("..."));
		String blobCrm = String.format("CRM: %s\n", optCrm.orElse("..."));
		String blobEsp = String.format("Especialização: %s\n", optEsp.orElse("..."));
		String blobCusto = String.format("Custo: %s\n", optCusto.orElse("..."));
		String blobHor = String.format("Horário: %s\n", optHor.orElse("..."));
		
		System.out.println("Sistema Hospitalar - Cadastro de Médico\n\n" + blobNome + blobCpf + blobIdade + blobCrm + blobEsp + optCusto + optHor);
	}
	
	public void dspReg(Registro reg) {
		String blobTitulo = "Sistema Hospitalar - Registro\n\n";
		System.out.println(reg.toString());
	}
}