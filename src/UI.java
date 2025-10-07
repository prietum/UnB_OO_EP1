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
			blobNome = String.format("\tNome: %s\n", optNome.get());
		} else {
			blobNome = String.format("\tNome: ...\n");
		}
		
		if (optCpf.isPresent()) {
			blobCpf = String.format("\tCPF: %s\n", optCpf.get().toString());
		} else {
			blobCpf = "\tCPF: ...\n";
		}
		
		if (optIdade.isPresent()) {
			blobIdade = String.format("\tIdade: %d\n", optIdade.get());
		} else {
			blobIdade = String.format("\tIdade: ...\n");
		}
		
		if (optHasPlano.isPresent()) {
			if (optPlano.isPresent()) {
				blobPlano = String.format("\tPlano: %s\n", optPlano.get().getNome());
			} else {
				blobPlano = "\tPlano: nenhum\n";
			}
		} else {
			blobPlano = "\tPlano: ...\n";
		}
		
		System.out.println("Sistema Hospitalar - Cadastro de Paciente\n\n" + blobNome + blobCpf + blobIdade + blobPlano + "\n");
	}
	
	public void dspCadMed(){
		Optional<String> optNome, 
		Optional<Cpf> optCpf, 
		Optional<Integer> optIdade, 
		Optional<Crm> optCrm, 
		Optional<Especializacao> optEsp,
		Optional<Float> optCusto,
		Optional<Horario> optHor,
		) {
			
		String blobNome;
		String blobCpf;
		String blobIdade;
		String blobCrm;
		String blobEsp;
		String blobCusto;
		String blobHor;
			
		if (optNome.isPresent()) {
			blobNome = String.format("\tNome: %s\n", optNome.get());
		} else {
			blobNome = String.format("\tNome: ...\n");
		}
		
		if (optCpf.isPresent()) {
			blobCpf = String.format("\tCPF: %s\n", optCpf.get().toString());
		} else {
			blobCpf = "\tCPF: ...\n";
		}
		
		if (optIdade.isPresent()) {
			blobIdade = String.format("\tIdade: %d\n", optIdade.get());
		} else {
			blobIdade = String.format("\tIdade: ...\n");
		}
		
		if (optCrm.isPresent()) {
			blobIdade = String.format("\tCRM: %s\n", optCrm.get().toString());
		} else {
			blobIdade = String.format("\tCRM: ...\n");
		}
		
		if (optEsp.isPresent()) {
			blobEsp = String.format("\Especialização: %s\n", optEsp.get().toString());
		} else {
			blobEsp = String.format("\Especialização: ...\n");
		}
		
		if (optCusto.isPresent()) {
			blobCusto = String.format("\Custo: R$%d\n", optCusto.get());
		} else {
			blobCusto = String.format("\Custo: ...\n");
		}
		
		if (optHor.isPresent()) {
			blobHor = String.format("\Horário: %s\n", optHor.get().toString());
		} else {
			blobHor = String.format("\Horário: ...\n");
		}
		
		System.out.println(
			"Sistema Hospitalar - Cadastro de Médico\n\n" + 
			blobNome + blobCpf + blobIdade + blobCrm + blobEsp + blobCusto + blobHor + 
			"\n");
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
		System.out.println(
			"Sistema Hospitalar - Administração\n\n" +
			"1. Gerir quartos\n" +
			"2. Gerir planos\n"
		);
	}
	
	public void dspMenuReg() {
		System.out.println(
			"Sistema Hospitalar - Registro\n\n" +
			"1. Printar registro\n" +
			"2. Salvar registro atual\n" +
			"3. Exportar registro para .txt\n"
		);
	}
	
	public void dspPrtReg(Registro reg) {
		String blobTitulo = "Sistema Hospitalar - Registro\n\n";
		System.out.println(blobTitulo + reg.toString());
	}
	
	public void dspSair() {
		System.out.printf(String.format("Fechando sistema hospitalar..."));
	}
	
	public void dspEnumEspecializacao() {
		System.out.println("Especializações (utilize o termo da esquerda):\n");
		for (Especializacao esp : Especializacao.values()) {
			System.out.println(String.format("\t%s\t%s\n", esp.name(), esp.toString()));
		}
	}
	
	public void dspEnumUfs() {
		System.out.println("Unidades Federativas (utilize o termo da esquerda):\n");
		for (UF uf : UF.values()) {
			System.out.println(String.format("\t%s\t%s\n", uf.name(), uf.toString()));
		}
	}
}