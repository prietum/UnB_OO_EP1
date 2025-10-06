import java.util.Scanner;
import java.util.Optional;

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
		ui.dspMenuReg(reg);
		
		Leitura ltr = leitor.lerInt(1,2);
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
		
		boolean repetir = false;
		
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
				
				if (ltr.isOk()) {
					String str = ltr.getStr();
					nome = str;
					ui.dspClear();
				} else {
					ui.dspClear();
					System.out.println(ltr.getStr());
				}
				
			} else if (cpf == null) {
				System.out.println("Digite o CPF do paciente.\n");
				Leitura ltr = leitor.lerCpf();
				
				if (ltr.isOk()) {
					int i = ltr.getInt();
					cpf = new Cpf(i);
					ui.dspClear();
				} else {
					ui.dspClear();
					System.out.println(ltr.getStr());
				}
				
			} else if (idade == null) {
				System.out.println("Digite a idade do paciente.\n");
				Leitura ltr = leitor.lerInt();
				
				if (ltr.isOk()) {
					int i = ltr.getInt();
					if (0 <= i && i <= 120) {
						idade = i;
						ui.dspClear();
					} else {
						ui.dspClear();
						System.out.println(ltr.getStr());
					}
				} else {
					ui.dspClear();
					System.out.println(ltr.getStr());
				}
				
			} else if (hasPlano == null) {
				if (reg.getPlanosSize() == 0) {
					hasPlano = false;
					break;
				}
				
				System.out.println("O paciente possui plano? (y/n)\n");
				Leitura ltr = leitor.lerBoo();
				
				if (ltr.isOk()) {
					boolean b = ltr.getBoo();
					hasPlano = b;
				} else {
					ui.dspClear();
					System.out.println(ltr.getStr());
				}
				
			} else if (plano == null && hasPlano) {
				System.out.println(reg.toStringPlanos() + "\nDigite o número do plano do paciente.\n");
				Leitura ltr = leitor.lerInt();
				
				if (ltr.isOk()) {
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
					ui.dspClear();
					System.out.println(ltr.getStr());
				}
			}
		
			System.out.println("Confirmar? (y/n)");
			Leitura ltr = leitor.lerBoo();
			
			if (ltr.isOk()) {
				boolean b = ltr.getBoo();
				repetir = !b;
				break;
			} else {
				ui.dspClear();
				System.out.println(ltr.getStr());
			}
		}
		
		if (!repetir) {
			Paciente pac;
			if (hasPlano) {
				pac = new PacienteEspecial(nome, cpf, idade, plano);
			} else {
				pac = new Paciente(nome, cpf, idade);
			}
			reg.putPaciente(pac);
			
			String.out.println("Paciente inserido.");
			leitor.pausa();
			ui.dspClear();
			stt = 0;
		}
	}
	
	private void pcsCadMed() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsCadCons() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsCadInter() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsCadDiag() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsAtuzCons() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
		stt = 0;
	}
	
	private void pcsAtuzInter() {
		System.out.println("Em stt: " + Integer.toString(stt));
		leitor.pausa();
		ui.dspClear();
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
						case 32: pcsExpReg(); break;		//exportar registro
						
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