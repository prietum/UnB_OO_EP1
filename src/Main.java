import java.util.Scanner;
import java.util.Optional;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Main {
	private int stt;
	private boolean running = true;
	
	private Registro reg = new Registro();
	private Leitor leitor = new Leitor();
	private UI ui = new UI();
	
	///////////////////////////////////////
	
	private void pcsMenuPrincipal() {
		ui.dspMenuPrincipal();
		
		Leitura ltr = leitor.lerInt(1,4);
		if (ltr.isOk()) {
			stt = ltr.getInt();
		} else {
			ui.dspClear();
			System.out.println(ltr.getStr());
			return;
		}
		
		ui.dspClear();
	}
	
	private void pcsMenuAtend() {
		ui.dspMenuAtend();
		
		Leitura ltr = leitor.lerInt(1,7);
		int c;
		if (ltr.isOk()) {
			stt = Integer.parseInt("1"+Integer.toString(ltr.getInt()));
		} else {
			ui.dspClear();
			System.out.println(ltr.getStr());
			return;
		}
		
		ui.dspClear();
	}
	
	private void pcsMenuAdmin() {
		ui.dspMenuAdmin();
		
		Leitura ltr = leitor.lerInt(1,2);
		int c;
		if (ltr.isOk()) {
			stt = Integer.parseInt("2"+Integer.toString(ltr.getInt()));
		} else {
			ui.dspClear();
			System.out.println(ltr.getStr());
			return;
		}
		
		ui.dspClear();
	}
	
	private void pcsMenuReg() {
		ui.dspMenuReg();
		
		Leitura ltr = leitor.lerInt(1,3);
		int c;
		if (ltr.isOk()) {
			stt = Integer.parseInt("3"+Integer.toString(ltr.getInt()));
		} else {
			ui.dspClear();
			System.out.println(ltr.getStr());
			return;
		}
		
		ui.dspClear();
	}
	
	private void pcsCadPac() {
		String nome = null;
		Cpf cpf = null;
		Integer idade = null;
		Boolean hasPlano = null;
		Plano plano = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspCadPac(
				Optional.ofNullable(nome),
				Optional.ofNullable(cpf),
				Optional.ofNullable(idade),
				Optional.ofNullable(hasPlano),
				Optional.ofNullable(plano)
			);
			
			if (nome == null) {
				System.out.println("Digite o nome do paciente.\n");
				Leitura ltr = leitor.lerString();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr().toUpperCase();
				nome = str;
				ui.dspClear();
				
			} else if (cpf == null) {
				System.out.println("Digite o CPF do paciente.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				Seq digitos = new Seq(ltr.getStr());
				cpf = new Cpf(digitos);
				ui.dspClear();
				
			} else if (idade == null) {
				System.out.println("Digite a idade do paciente.\n");
				Leitura ltr = leitor.lerInt(0, 120);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				idade = i;
				ui.dspClear();
				
			} else if (hasPlano == null && reg.getPlanosSize() > 0) {
				System.out.println("O paciente possui plano? (y/n)\n");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				boolean b = ltr.getBoo();
				hasPlano = b;
				
			} else if (plano == null && hasPlano != null && hasPlano) {
				System.out.println(reg.toStringPlanos() + "\nDigite o número do plano do paciente.\n");
				Leitura ltr = leitor.lerInt();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				Plano p = reg.getPlano(i);
				if (p != null) {
					plano = p;
					ui.dspClear();
				} else {
					ui.dspClear();
					System.out.println("O número inserido anteriormente não corresponde a nenhum plano.");
				}
					
			} else {
				System.out.println("Confirmar? (y/n)");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				confirma = ltr.getBoo();
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			Paciente pac;
			if (hasPlano != null && hasPlano && reg.getPlanosSize() > 0) {
				pac = new PacienteEspecial(nome, cpf, idade, plano);
			} else {
				pac = new Paciente(nome, cpf, idade);
			}
			reg.putPaciente(pac);
			
			System.out.println("O paciente foi cadastrado.");
		} else {
			System.out.println("O paciente NÃO foi cadastrado.");
		}
		
		stt = 0;
	}
	
	private void pcsCadMed() {
		String nome = null;
		Cpf cpf = null;
		Integer idade = null;
		Crm crm = null;
		Especializacao esp = null;
		Float custo = null;
		Horario hor = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspCadMed(
				Optional.ofNullable(nome),
				Optional.ofNullable(cpf),
				Optional.ofNullable(idade),
				Optional.ofNullable(crm),
				Optional.ofNullable(esp),
				Optional.ofNullable(custo),
				Optional.ofNullable(hor)
			);
			
			if (nome == null) {
				System.out.println("Digite o nome do médico.\n");
				Leitura ltr = leitor.lerString(true);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr().toUpperCase();
				nome = str;
				ui.dspClear();
				
			} else if (cpf == null) {
				System.out.println("Digite o CPF do médico (11 dígitos).\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				Seq digitos = new Seq(ltr.getStr());
				cpf = new Cpf(digitos);
				ui.dspClear();
				
			} else if (idade == null) {
				System.out.println("Digite a idade do médico (entre 0 e 120).\n");
				Leitura ltr = leitor.lerInt(0,120);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				idade = i;
				ui.dspClear();
				
			} else if (crm == null) {
				ui.dspEnumUf();
				System.out.println("Digite o CRM do médico (6 dígitos + UF).");
				Leitura ltr = leitor.lerCrm();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				crm = new Crm(str);
				ui.dspClear();
				
			} else if (esp == null) {
				ui.dspEnumEspecializacao();
				System.out.println("Digite a especialização do médico.");
				Leitura ltr = leitor.lerEsp();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				esp = Especializacao.valueOf(str);
				ui.dspClear();
				
			} else if (custo == null) {
				System.out.println("Digite o custo da consulta com o médico.\n");
				Leitura ltr = leitor.lerFlo(0);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				custo = ltr.getFlo();
				ui.dspClear();
				
			} else if (hor == null) {
				System.out.println("Digite o horário disponibilizado pelo médico.\n\tFormato: 'X Y', onde:\n\t\tambos são números inteiros e estão entre 0 e 24;\n\t\tX deve ser menor que Y.\n\n\t\tExemplo: 12 14 == \"12:00-14:00\"\n");
				
				Leitura ltr = leitor.lerString(true);
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				String[] args = str.split("[\s]");
				
				if (args.length != 2) {
					ui.dspClear();
					System.out.println("Insira exatamente dois termos.");
					continue;
				}
				
				Integer i0;
				Integer i1;
				boolean ok = true;
				
				try {
					Integer.valueOf(args[0]);
				} catch (NumberFormatException e) {
					System.out.println("O primeiro termo não é número.");
					ok = false;
				}
				
				if (ok) {
					i0 = Integer.valueOf(args[0]);
				} else {
					continue;
				}
				
				try {
					Integer.valueOf(args[1]);
				} catch (NumberFormatException e) {
					System.out.println("O segundo termo não é número.");
					ok = false;
				}
				
				if (ok) {
					i1 = Integer.valueOf(args[1]);
				} else {
					continue;
				}
				
				if (i0 < 0 || i0 > 24) {
					System.out.println("O primeiro número deve estar contido entre 0 e 24.");
					continue;
				}
				
				if (i1 < 0 || i1 > 24) {
					System.out.println("O segundo número deve estar contido entre 0 e 24.");
					continue;
				}
				
				if (i0 >= i1) {
					System.out.println("O primeiro número deve ser menor que o segundo número.");
					continue;
				}
				
				hor = new Horario(i0, i1);
				ui.dspClear();
				
			} else {
				System.out.println("Confirmar? (y/n)");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				confirma = ltr.getBoo();
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			Medico med = new Medico(nome, cpf, idade, crm, esp, custo, hor);
			reg.putMedico(med);
			
			System.out.println("O médico foi cadastrado.");
		} else {
			System.out.println("O médico NÃO foi cadastrado.");
		}
		
		stt = 0;
	}
	
	private void pcsCadCons() {
		boolean p0 = reg.getPacientesSize() > 0;
		boolean p1 = reg.getMedicosSize() > 0;
		
		if (!(p0&&p1)) {
			ui.dspClear();
			if (!p0) {System.out.println("Não há pacientes no registro para fazer o registro de consulta. Adicione pelo menos 1 paciente.");}
			if (!p1) {System.out.println("Não há médicos no registro para fazer o registro de consulta. Adicione pelo menos 1 médico.");}
			stt = 0;
			return;
		}
		
		Paciente pac = null;
		Medico med = null;
		LocalDate dat = null;
		Status status = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspCadCons(
				Optional.ofNullable(pac),
				Optional.ofNullable(med),
				Optional.ofNullable(dat),
				Optional.ofNullable(status)
			);
			
			if (pac == null) {
				System.out.println(reg.toStringPacientes());
				System.out.println("Digite o CPF do paciente da consulta.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Paciente temp = reg.getPaciente(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe paciente com CPF %s.", str));
					continue;
				}
				
				pac = temp;
				ui.dspClear();
				
			} else if (med == null) {
				System.out.println(reg.toStringMedicos());
				System.out.println("Digite o CPF do médico da consulta.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Medico temp = reg.getMedico(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe médico com CPF %s.", str));
					continue;
				}
				
				med = temp;
				ui.dspClear();
				
			} else if (dat == null) {
				System.out.println("Digite a data da consulta. (aaaa-mm-dd)\n");
				Leitura ltr = leitor.lerDat();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				dat = LocalDate.parse(str);
				
			} else if (status == null) {
				System.out.println("Digite o status da consulta:\n\t0 == Agendada;\n\t1 == Concluída\n\t2 == Cancelada");
				Leitura ltr = leitor.lerInt(0,2);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				status = new Status(i);
				
			} else {
				System.out.println("Confirmar? (y/n)");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				confirma = ltr.getBoo();
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			Consulta cons = new Consulta(pac, med, dat, status);
			reg.addConsulta(cons);
			
			System.out.println("A consulta foi adicionada ao registro.");
		} else {
			System.out.println("A consulta NÃO foi adicionada ao registro.");
		}
		
		stt = 0;
	}
	
	private void pcsCadInter() {
		boolean p0 = reg.getPacientesSize() > 0;
		boolean p1 = reg.getMedicosSize() > 0;
		boolean p2 = reg.getQuartosSize() > 0;
		
		if (!(p0&&p1&&p2)) {
			ui.dspClear();
			if (!p0) {System.out.println("Não há pacientes no registro para fazer o registro de internação. Adicione pelo menos 1 paciente.");}
			if (!p1) {System.out.println("Não há médicos no registro para fazer o registro de internação. Adicione pelo menos 1 médico.");}
			if (!p2) {System.out.println("Não há quartos no registro para fazer o registro de internação. Adicione pelo menos 1 quarto.");}
			stt = 0;
			return;
		}
		
		Paciente pac = null;
		Medico med = null;
		Periodo per = null;
		Quarto qua = null;
		Status status = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspCadInter(
				Optional.ofNullable(pac),
				Optional.ofNullable(med),
				Optional.ofNullable(per),
				Optional.ofNullable(qua),
				Optional.ofNullable(status)
			);
			
			if (pac == null) {
				System.out.println(reg.toStringPacientes());
				System.out.println("Digite o CPF do paciente internado.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Paciente temp = reg.getPaciente(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe paciente com CPF %s.", str));
					continue;
				}
				
				pac = temp;
				ui.dspClear();
				
			} else if (med == null) {
				System.out.println(reg.toStringMedicos());
				System.out.println("Digite o CPF do médico responsável pela internação.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Medico temp = reg.getMedico(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe médico com CPF %s.", str));
					continue;
				}
				
				med = temp;
				ui.dspClear();
				
			} else if (per == null) {
				System.out.println("Digite o período de internação do paciente.\n\tFormato: 'X Y', onde:\n\t\tambos são escritos em formato aaaa-mm-dd;\n\t\tX deve ser anterior a Y.\n\n\t\tExemplo: 2020-01-01 2020-02-01 significa que a internação durou desde 1º de Janeiro de 2020 até 1º de Fevereiro de 2020.\n");
				
				Leitura ltr = leitor.lerString(true);
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				String[] args = str.split("[\s]");
				
				if (args.length != 2) {
					ui.dspClear();
					System.out.println("Insira exatamente dois termos.");
					continue;
				}
				
				LocalDate d0;
				LocalDate d1;
				boolean ok = true;
				
				try {
					LocalDate.parse(args[0]);
				} catch (DateTimeParseException e) {
					ok = false;
				}
				
				if (ok) {
					d0 = LocalDate.parse(args[0]);
				} else {
					ui.dspClear();
					System.out.println("O primeiro termo não é data válida ou não está no formato correto.");
					continue;
				}
				
				try {
					LocalDate.parse(args[1]);
				} catch (DateTimeParseException e) {
					ok = false;
				}
				
				if (ok) {
					d1 = LocalDate.parse(args[1]);
				} else {
					ui.dspClear();
					System.out.println("O segundo termo não é data válida ou não está no formato correto.");
					continue;
				}
				
				if (d0.isAfter(d1)) {
					ui.dspClear();
					System.out.println("A primeira data deve ser anterior a segunda.");
					continue;
				}
				
				per = new Periodo(d0, d1);
				ui.dspClear();
				
			} else if (qua == null) {
				System.out.println(reg.toStringQuartos());
				System.out.println("Digite o nº do quarto da internação.\n");
				Leitura ltr = leitor.lerInt();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				Quarto temp = reg.getQuarto(i);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe quarto com nº %d.", i));
					continue;
				}
				
				qua = temp;
				ui.dspClear();
				
			} else if (status == null) {
				System.out.println("Digite o status da consulta:\n\t0 == Agendada;\n\t1 == Concluída\n\t2 == Cancelada");
				Leitura ltr = leitor.lerInt(0,2);
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				status = new Status(i);
				
			} else {
				System.out.println("Confirmar? (y/n)");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				confirma = ltr.getBoo();
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			Internacao inter = new Internacao(pac, med, per, qua, status);
			reg.addInternacao(inter);
			
			System.out.println("A internação foi adicionada ao registro.");
		} else {
			System.out.println("A internação NÃO foi adicionada ao registro.");
		}
		
		stt = 0;
	}
	
	private void pcsCadDiag() {
		boolean p0 = reg.getPacientesSize() > 0;
		boolean p1 = reg.getMedicosSize() > 0;
		
		if (!(p0&&p1)) {
			ui.dspClear();
			if (!p0) {System.out.println("Não há pacientes no registro para fazer o registro de diagnóstico. Adicione pelo menos 1 paciente.");}
			if (!p1) {System.out.println("Não há médicos no registro para fazer o registro de diagnóstico. Adicione pelo menos 1 médico.");}
			stt = 0;
			return;
		}
		
		Paciente pac = null;
		Medico med = null;
		LocalDate dat = null;
		String conc = null;
		String pres = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspCadDiag(
				Optional.ofNullable(pac),
				Optional.ofNullable(med),
				Optional.ofNullable(dat),
				Optional.ofNullable(conc),
				Optional.ofNullable(pres)
			);
			
			if (pac == null) {
				System.out.println(reg.toStringPacientes());
				System.out.println("Digite o CPF do paciente do diagnóstico.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Paciente temp = reg.getPaciente(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe paciente com CPF %s.", str));
					continue;
				}
				
				pac = temp;
				ui.dspClear();
				
			} else if (med == null) {
				System.out.println(reg.toStringMedicos());
				System.out.println("Digite o CPF do médico do diagnóstico.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				Medico temp = reg.getMedico(str);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe médico com CPF %s.", str));
					continue;
				}
				
				med = temp;
				ui.dspClear();
				
			} else if (dat == null) {
				System.out.println("Digite a data do diagnóstico. (aaaa-mm-dd)\n");
				Leitura ltr = leitor.lerDat();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				dat = LocalDate.parse(str);
				
			} else if (conc == null) {
				System.out.println("Escreva o que foi concluído no diagnóstico (sintomas, etc).");
				Leitura ltr = leitor.lerString();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				conc = str;
				
			} else if (pres == null) {
				System.out.println("Escreva o que foi prescrito para o paciente no diagnóstico (remédios, etc).");
				Leitura ltr = leitor.lerString();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				String str = ltr.getStr();
				pres = str;
				
			} else {
				System.out.println("Confirmar? (y/n)");
				Leitura ltr = leitor.lerBoo();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				confirma = ltr.getBoo();
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			Diagnostico diag = new Diagnostico(med, pac, dat, conc, pres);
			reg.addDiagnostico(diag);
			
			System.out.println("O diagnóstico foi adicionada ao registro.");
		} else {
			System.out.println("O diagnóstico NÃO foi adicionada ao registro.");
		}
		
		stt = 0;
	}
	
	/// pcsAtuzCons() e pcsAtuzInter() servem para atualizar o status de Consulta e Internação de apenas "Agendada" para "Concluída" ou "Cancelada".
	private void pcsAtuzCons() {
		boolean p0 = reg.getConsultasSize() > 0;
		
		if (!p0) {
			ui.dspClear();
			if (!p0) {System.out.println("Não há consultas no registro para atualizar. Adicione pelo menos 1 consulta.");}
			stt = 0;
			return;
		}
		
		Integer consId = null;
		Consulta cons = null
		Integer dec = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspAtuzCons(
				Optional.ofNullable(consId),
				Optional.ofNullable(dec),
			);
			
			if (consId == null) {
				System.out.println(reg.toStringConsultas());
				System.out.println("Digite o nº da consulta. Apenas consultas com status de \"agendada\" podem ser atualizadas.\n");
				Leitura ltr = leitor.lerInt();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				Consulta temp = reg.getConsulta(i);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe consulta com nº %d.", i));
					continue;
				}
				
				consId = i;
				cons = temp;
				ui.dspClear();
				
				if (cons.getStatus.getInt() != 0) {
					dec = 2;
				}
				
			} else if (cons.getStatus.getInt() == 0) {
				if (dec == null) {
					System.out.println("Digite 0 para concluir a consulta e 1 para cancelar a consulta.\n");
					Leitura ltr = leitor.lerInt(0,1);
					
					if (!ltr.isOk()) {
						ui.dspClear();
						System.out.println(ltr.getStr());
						continue;
					}
					
					int i = ltr.getInt();
					dec = i;
					
					ui.dspClear();
					
				} else {
					System.out.println("Confirmar? (y/n)");
					leitor.pause();
					
					if (!ltr.isOk()) {
						ui.dspClear();
						System.out.println(ltr.getStr());
						continue;
					}
					
					confirma = ltr.getBoo();
					break;
				}
			} else {
				System.out.println("Não há como atualizar uma consulta já concluída ou cancelada. Pressione Enter para prosseguir para o menu principal.");
				leitor.pause();
				
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			if (dec == 0) {
				cons.setConcluido();
				System.out.println("A consulta foi atualizada para \"concluída\".");
			} else {
				cons.setCancelado();
				System.out.println("A consulta foi atualizada para \"cancelada\".");
			}
			
		} else {
			System.out.println("A consulta NÃO foi atualizada.");
		}
		
		stt = 0;
	}
	
	private void pcsAtuzInter() {
		boolean p0 = reg.getInternacoesSize() > 0;
		
		if (!p0) {
			ui.dspClear();
			if (!p0) {System.out.println("Não há internações no registro para atualizar. Adicione pelo menos 1 internação.");}
			stt = 0;
			return;
		}
		
		Integer interId = null;
		Internacao inter = null
		Integer dec = null;
		
		boolean confirma;
		
		while (true) {
			ui.dspAtuzCons(
				Optional.ofNullable(interId),
				Optional.ofNullable(dec),
			);
			
			if (interId == null) {
				System.out.println(reg.toStringInternacoes());
				System.out.println("Digite o nº da internação. Apenas internações com status de \"agendada\" podem ser atualizadas.\n");
				Leitura ltr = leitor.lerInt();
				
				if (!ltr.isOk()) {
					ui.dspClear();
					System.out.println(ltr.getStr());
					continue;
				}
				
				int i = ltr.getInt();
				Internacao temp = reg.getInternacao(i);
				if (temp == null) {
					ui.dspClear();
					System.out.println(String.format("Não existe internação com nº %d.", i));
					continue;
				}
				
				interId = i;
				inter = temp;
				ui.dspClear();
				
				if (inter.getStatus.getInt() != 0) {
					dec = 2;
				}
				
			} else if (cons.getStatus.getInt() == 0) {
				if (dec == null) {
					System.out.println("Digite 0 para concluir a internação e 1 para cancelar a internação.\n");
					Leitura ltr = leitor.lerInt(0,1);
					
					if (!ltr.isOk()) {
						ui.dspClear();
						System.out.println(ltr.getStr());
						continue;
					}
					
					int i = ltr.getInt();
					dec = i;
					
					ui.dspClear();
					
				} else {
					System.out.println("Confirmar? (y/n)");
					leitor.pause();
					
					if (!ltr.isOk()) {
						ui.dspClear();
						System.out.println(ltr.getStr());
						continue;
					}
					
					confirma = ltr.getBoo();
					break;
				}
			} else {
				System.out.println("Não há como atualizar uma internação já concluída ou cancelada. Pressione Enter para prosseguir para o menu principal.");
				leitor.pause();
				
				break;
			}
		}
		
		ui.dspClear();
		if (confirma) {
			if (dec == 0) {
				inter.setConcluido();
				System.out.println("A internação foi atualizada para \"concluída\".");
			} else {
				inter.setCancelado();
				System.out.println("A internação foi atualizada para \"cancelada\".");
			}
			
		} else {
			System.out.println("A internação NÃO foi atualizada.");
		}
		
		stt = 0;
	}
	
	private void pcsGerQuar() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsGerPlan() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsPrtReg() {
		ui.dspPrtReg(reg);
		
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsSavReg() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsExpReg() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
	
	public void run() {
		ui.dspClear();
		while (running) {
			switch (stt) {
				case 0: pcsMenuPrincipal(); break;
					case 1: pcsMenuAtend(); break;
						case 11: pcsCadPac(); break;		//cadastra paciente
						case 12: pcsCadMed(); break;		//cadastra medico
						case 13: pcsCadCons(); break;		//cadastra consulta
						case 14: pcsCadInter(); break;		//cadastra internacao
						case 15: pcsCadDiag(); break;		//cadastra diagnostico
						case 16: pcsAtuzCons(); break;		//atualiza consulta
						case 17: pcsAtuzInter(); break;		//atualiza internacao
						
					case 2: pcsMenuAdmin(); break;
						case 21: pcsGerQuar(); break;		//gerir quartos
						case 22: pcsGerPlan(); break;		//gerir planos
						
					case 3: pcsMenuReg(); break;
						case 31: pcsPrtReg(); break;		//printar registro
						case 32: pcsExpReg(); break;		//exportar registro para data.txt
						case 33: pcsSavReg(); break;		//salvar registro em /data/*.csv
						
					case 4: running = false; break;			//sair
				
				default: stt = 0;
			}
		}
		sair();
	}
	
	public void sair() {
		ui.dspSair();
	}
}