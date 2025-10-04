import java.util.Scanner;

public class Main {
	//pcs :: "processa"
	//stt :: "status", qual tela mostrar, quais entradas pedir, etc.
	
	private int stt;
	private Scanner scn = new Scanner(System.in);
	private UI ui = new UI();
	
	private void pcsMenu() {
		ui.dspClear();
		ui.dspMenu();
		scn.nextLine();
	}
	
	private void pcsCadPac() {
		ui.dspClear();
		scn.nextLine();
	}
	
	private void pcsCadPacEsp() {
		ui.dspClear();
		scn.nextLine();
	}
	
	private void pcsCadMed() {
		ui.dspClear();
		scn.nextLine();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
	
	public void run() {
		while (true) {
			switch (stt) {
				case 0: pcsMenu(); break;
				case 1: pcsCadPac(); break;
				case 2: pcsCadPacEsp(); break;
				case 3: pcsCadMed(); break;
				default: stt = 0;
			}
		}
	}
}