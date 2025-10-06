import java.util.HashMap;
import java.util.Optional;

public class UI {
	public void dspClear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void dspMenuPrincipal() {
		System.out.printf(String.format(
			"Sistema Hospitalar - Menu Principal\n\n" +
			"1. Atendimento\n" +
			"2. Administração\n" +
			"3. Registro\n" +
			"4. Sair\n\n"
			));
	}
	
	public void dspMenuAtend() {
		System.out.println(String.format(
			"Sistema Hospitalar - Atendimento\n\n" +
			"1. Cadastrar paciente\n" +
			"2. Cadastrar médico\n" +
			"3. Cadastrar consulta\n" +
			"4. Cadastrar internação\n\n" +
			"5. Cadastrar diagnóstico\n\n" +
			
			"6. Atualizar consulta\n" +
			"7. Atualizar internação\n\n"
			));
	}
	
	public void dspCadPac(
		Optional<String> optNome, 
		Optional<Cpf> optCpf, 
		Optional<Integer> optIdade, 
		Optional<Boolean> optHasPlano, 
		Optional<Plano> optPlano
		) {
			
		String blobNome;
		String blobCpf;
		String blobIdade;
		String blobPlano;
			
		if (optNome.isPresent()) {
			blobNome = String.format("Nome: %s\n", optNome.get());
		} else {
			blobNome = String.format("Nome: ...");
		}
		
		if (optCpf.isPresent()) {
			blobCpf = String.format("CPF: %s\n", optCpf.get().toString());
		} else {
			blobCpf = "CPF: ...";
		}
		
		if (optIdade.isPresent()) {
			blobIdade = String.format("Idade: %s\n", Integer.toString(optIdade.get()));
		} else {
			blobIdade = String.format("Idade: ...");
		}
		
		if (optHasPlano.isPresent()) {
			if (optPlano.isPresent()) {
				blobPlano = String.format("Plano: %s\n", optPlano.get().getNome());
			} else {
				blobPlano = "Plano: nenhum\n";
			}
		} else {
			blobPlano = "Plano: ...\n";
		}
		
		System.out.println("Sistema Hospitalar - Cadastro de Paciente\n\n" + blobNome + blobCpf + blobIdade + blobPlano + "\n");
	}
	
	public void dspCadMed(){
		//CORRIGIR CONFORME dspCadPac
		/* Optional<String> optNome, 
		Optional<Cpf> optCpf, 
		Optional<Integer> optIdade, 
		Optional<Crm> optCrm,
		Optional<Especializacao> optEsp,
		Optional<Float> optCusto,
		Optional<Horario> optHor
		) {
			
		String blobNome = String.format("Nome: %s\n", optNome.orElse("..."));
		String blobCpf = String.format("CPF: %s\n", optCpf.orElse("..."));
		String blobIdade = String.format("Idade: %s\n", optIdade.orElse("..."));
		String blobCrm = String.format("CRM: %s\n", optCrm.orElse("..."));
		String blobEsp = String.format("Especialização: %s\n", optEsp.orElse("..."));
		String blobCusto = String.format("Custo: R$%s\n", optCusto.orElse("..."));
		String blobHor = String.format("Horário: %s\n", optHor.orElse("..."));
		
		System.out.println("Sistema Hospitalar - Cadastro de Médico\n\n" + blobNome + blobCpf + blobIdade + blobCrm + blobEsp + optCusto + optHor + "\n"); */
	}
	
	public void dspCadCons(
		
		) {
		
	}
	
	public void dspCadInter(
		
		) {
		
	}
	
	public void dspCadDiag(
		
		) {
		
	}
	
	public void dspAtuzCons(
		
		) {
		
	}
	
	public void dspAtuzInter(
		
		) {
		
	}
	
	public void dspRemPac(
		
		) {
		
	}
	
	public void dspRemMed(
		
		) {
		
	}
	
	public void dspMenuAdmin() {
		System.out.println(String.format(
			"Sistema Hospitalar - Administração\n\n" +
			"1. Gerir quartos\n" +
			"2. Gerir planos\n"
			));
	}
	
	public void dspMenuReg(Registro reg) {
		String blobTitulo = "Sistema Hospitalar - Registro\n\n";
		System.out.println(reg.toString());
	}
	
	public void dspSair() {
		System.out.printf(String.format("Fechando sistema hospitalar..."));
	}
}