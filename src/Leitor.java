import java.util.Scanner;

public class Leitor {
	private Scanner scn = new Scanner(System.in);
	
	public void pausa() {
		scn.nextLine();
	}
	
	public Leitura lerString() {
		String str = scn.nextLine();
		return new Leitura(str, true);
	}
	
	public Leitura lerString(boolean obrigatorio) {
		String str = scn.nextLine();
		if (obrigatorio && str.length() > 0) {
			return new Leitura(str, true);
		} else {
			return new Leitura("Insira o valor requerido.", false);
		}
	}
	
	public Leitura lerInt() {
		String str = scn.nextLine();
		int i;
		
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return new Leitura("Insira um número válido.", false);
		}
		
		return new Leitura(i, true);
	}
	
	public Leitura lerInt(int n, int m) {
		if (n > m) {
			return new Leitura(String.format("Insira um número entre %d e %d.", n, m), false);
		} else {
			Leitura ltr = this.lerInt();
			int i = ltr.getInt();
			
			if (!ltr.isOk()) {
				return ltr;
			}
			
			if (n <= i && i <= m) {
				return ltr;
			} else {
				return new Leitura(String.format("Insira um número entre %d e %d.", n, m), false);
			}
		}
	}
	
	public Leitura lerBoo() {
		Leitura ltr = this.lerString(true);
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr();
		if (str.equalsIgnoreCase("y")) {
			return new Leitura(true, true);
		} else if (str.equalsIgnoreCase("n")) {
			return new Leitura(false, true);
		} else {
			return new Leitura("Insira Y (sim) ou N (não).", false);
		}
	}
	
	public Leitura lerCpf() {
		Leitura ltr = this.lerString(true);
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr();
		int i;
		
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return new Leitura("Insira somente números.", false);
		}
		
		if (str.length() != 11) {
			return new Leitura("Insira um CPF de 11 dígitos.", false);
		}
		
		return new Leitura(i, true);
	}
	
/* 	public Leitura lerCrmInt() {
		
	} */
}