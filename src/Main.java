public class Main() implements UI{
	//pcs :: "processa"
	//stt :: "status", qual tela mostrar, quais entradas pedir, etc.
	private int stt;
	
	private void pcsMenu() {
		dspMenu();
	}
	
	private void pcsCadPac() {
		dspCadPac();
	}
	
	private void pcsCadPacEsp() {
		dspCadPacEsp();
	}
	
	private void pcsCadMed() {
		dspCadMed();
	}
	
	public static void main() {
		run();
	}
	
	public void run() {
		while (true) {
			switch (stt) {
			case 0: pcsMenu() break;
			case 1: pcsCadPac() break;
			case 2: pcsCadPacEsp() break;
			case 3: pcsCadMed() break;
			default: stt = 0;
		}
	}
}