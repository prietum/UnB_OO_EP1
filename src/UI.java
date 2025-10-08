import java.util.HashMap;
import java.util.Optional;
import java.time.*;

public class UI {
	public void dspClear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
	
	public void dspCadMed(
		Optional<String> optNome, 
		Optional<Cpf> optCpf, 
		Optional<Integer> optIdade, 
		Optional<Crm> optCrm, 
		Optional<Especializacao> optEsp,
		Optional<Float> optCusto,
		Optional<Horario> optHor
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
			blobCrm = String.format("\tCRM: %s\n", optCrm.get().toString());
		} else {
			blobCrm = String.format("\tCRM: ...\n");
		}
		
		if (optEsp.isPresent()) {
			blobEsp = String.format("\tEspecialização: %s\n", optEsp.get().toString());
		} else {
			blobEsp = String.format("\tEspecialização: ...\n");
		}
		
		if (optCusto.isPresent()) {
			blobCusto = String.format("\tCusto: R$%.2f\n", optCusto.get());
		} else {
			blobCusto = String.format("\tCusto: ...\n");
		}
		
		if (optHor.isPresent()) {
			blobHor = String.format("\tHorário: %s\n", optHor.get().toString());
		} else {
			blobHor = String.format("\tHorário: ...\n");
		}
		
		System.out.println(
			"Sistema Hospitalar - Cadastro de Médico\n\n" + 
			blobNome + blobCpf + blobIdade + blobCrm + blobEsp + blobCusto + blobHor + 
			"\n");
	}
	
	public void dspCadCons(
		Optional<Paciente> optPac, 
		Optional<Medico> optMed, 
		Optional<LocalDate> optDat, 
		Optional<Status> optStatus
		) {
			
		String blobPac;
		String blobMed;
		String blobDat;
		String blobStatus;
			
		if (optPac.isPresent()) {
			blobPac = String.format("\tPaciente: %s\n", optPac.get().getNome());
		} else {
			blobPac = String.format("\tPaciente: ...\n");
		}
		
		if (optMed.isPresent()) {
			blobMed = String.format("\tMédico: %s\n", optMed.get().getNome());
		} else {
			blobMed = "\tMédico: ...\n";
		}
		
		if (optDat.isPresent()) {
			blobDat = String.format("\tData: %s\n", optDat.get().toString());
		} else {
			blobDat = String.format("\tData: ...\n");
		}
		
		if (optStatus.isPresent()) {
			blobStatus = String.format("\tStatus: %s\n", optStatus.get().toString());
		} else {
			blobStatus = String.format("\tStatus: ...\n");
		}
		
		System.out.println(
			"Sistema Hospitalar - Registro de Consulta\n\n" + 
			blobPac + blobMed + blobDat + blobStatus +
			"\n");
	}
	
	public void dspCadInter(
		Optional<Paciente> optPac, 
		Optional<Medico> optMed, 
		Optional<Periodo> optPer, 
		Optional<Quarto> optQua, 
		Optional<Status> optStatus
		) {
			
		String blobPac;
		String blobMed;
		String blobPer;
		String blobQua;
		String blobStatus;
			
		if (optPac.isPresent()) {
			blobPac = String.format("\tPaciente: %s\n", optPac.get().getNome());
		} else {
			blobPac = String.format("\tPaciente: ...\n");
		}
		
		if (optMed.isPresent()) {
			blobMed = String.format("\tMédico: %s\n", optMed.get().getNome());
		} else {
			blobMed = "\tMédico: ...\n";
		}
		
		if (optPer.isPresent()) {
			blobPer = String.format("\tPeriodo: %s\n", optPer.get().toString());
		} else {
			blobPer = String.format("\tPeriodo: ...\n");
		}
		
		if (optQua.isPresent()) {
			blobQua = String.format("\tQuarto: nº%d\n", optQua.get().getId());
		} else {
			blobQua = String.format("\tQuarto: ...\n");
		}
		
		if (optStatus.isPresent()) {
			blobStatus = String.format("\tStatus: %s\n", optStatus.get().toString());
		} else {
			blobStatus = String.format("\tStatus: ...\n");
		}
		
		System.out.println(
			"Sistema Hospitalar - Registro de Internação\n\n" + 
			blobPac + blobMed + blobPer + blobQua + blobStatus +
			"\n");
	}
	
	public void dspCadDiag(
		Optional<Paciente> optPac, 
		Optional<Medico> optMed, 
		Optional<LocalDate> optDat, 
		Optional<String> optConc,
		Optional<String> optPres
		) {
			
		String blobPac;
		String blobMed;
		String blobDat;
		String blobConc;
		String blobPres;
			
		if (optPac.isPresent()) {
			blobPac = String.format("\tPaciente: %s\n", optPac.get().getNome());
		} else {
			blobPac = String.format("\tPaciente: ...\n");
		}
		
		if (optMed.isPresent()) {
			blobMed = String.format("\tMédico: %s\n", optMed.get().getNome());
		} else {
			blobMed = "\tMédico: ...\n";
		}
		
		if (optDat.isPresent()) {
			blobDat = String.format("\tData: %s\n", optDat.get().toString());
		} else {
			blobDat = String.format("\tData: ...\n");
		}
		
		if (optConc.isPresent()) {
			blobConc = String.format("\tConclusão: %s\n", optConc.get());
		} else {
			blobConc = String.format("\tConclusão: ...\n");
		}
		
		if (optPres.isPresent()) {
			blobPres = String.format("\tPrescrição: %s\n", optPres.get());
		} else {
			blobPres = String.format("\tPrescrição: ...\n");
		}
		
		System.out.println(
			"Sistema Hospitalar - Registro de Diagnóstico\n\n" + 
			blobPac + blobMed + blobDat + blobConc + blobPres +
			"\n");
	}
	
	public void dspAtuzCons(
		
		) {
		
	}
	
	public void dspAtuzInter(
		
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
		System.out.println("Especializações (utilize o termo da esquerda):");
		for (Especializacao esp : Especializacao.values()) {
			System.out.println(String.format("\t%s\t%s", esp.name(), esp.toString()));
		}
		System.out.println("");
	}
	
	public void dspEnumUf() {
		System.out.println("Unidades Federativas (utilize o termo da esquerda):");
		for (UF uf : UF.values()) {
			System.out.println(String.format("\t%s\t%s", uf.name(), uf.toString()));
		}
		System.out.println("");
	}
}