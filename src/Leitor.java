// serve para abstrair a leitura de valores

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Leitor {
	private Scanner scn = new Scanner(System.in);
	
	public void pausa() {
		scn.nextLine();
	}
	
	public Leitura lerString() {
		String str = scn.nextLine();
		str = str.replace("\n","").replace("\r","");
		return new Leitura(str, true);
	}
	
	public Leitura lerString(boolean obrigatorio) {
		String str = scn.nextLine();
		str = str.replace("\n","").replace("\r","");
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
	
	public Leitura lerFlo() {
		Leitura ltr = this.lerString();
		
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr();
		float f;
		
		try {
			f = Float.valueOf(str);
		} catch (NumberFormatException e) {
			return new Leitura("Insira um número válido.", false);
		}
		
		return new Leitura(f, true);
	}
	
	public Leitura lerFlo(float n, float m) {
		if (n > m) {
			return new Leitura(String.format("Insira um número entre %d e %d.", n, m), false);
		} else {
			Leitura ltr = this.lerFlo();
			if (!ltr.isOk()) {
				return ltr;
			}
			
			float f = ltr.getFlo();
			
			if (n <= f && f <= m) {
				return ltr;
			} else {
				return new Leitura(String.format("Insira um número entre %d e %d.", n, m), false);
			}
		}
	}
	
	public Leitura lerFlo(float n) {
		Leitura ltr = this.lerFlo();
			if (!ltr.isOk()) {
				return ltr;
			}
			
		float f = ltr.getFlo();
			
		if (n > f) {
			return new Leitura(String.format("Insira um número maior ou igual a %d.", n), false);
		}
		
		return ltr;
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
		Seq digitos;
		
		try {
			digitos = new Seq(str);
		} catch (NumberFormatException e) {
			return new Leitura("Insira somente números.\n"+e.getMessage(), false);
		}
		
		if (str.length() != 11) {
			return new Leitura("Insira um CPF de 11 dígitos.", false);
		}
		
		return new Leitura(str, true);
	}
	
	public Leitura lerCrm() {
		Leitura ltr = this.lerString(true);
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr().toUpperCase();
		
		if (str.length() != 8) {
			return new Leitura("Insira um CRM de 8 dígitos (6 números + 2 letras).", false);
		}
		
		try {
			new Seq(str.substring(0,6));
		} catch (NumberFormatException e) {
			return new Leitura("Os seis primeiros dígitos devem ser números.", false);
		}
		
		try {
			UF.valueOf(str.substring(6,8));
		} catch (IllegalArgumentException e) {
			return new Leitura("Os dois últimos dígitos devem corresponder a uma unidade federativa válida.", false);
		}
		
		return new Leitura(str, true);
	}
	
	public Leitura lerEsp() {
		Leitura ltr = this.lerString(true);
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr().toUpperCase();
		
		try {
			Especializacao.valueOf(str);
		} catch (IllegalArgumentException e) {
			return new Leitura("Insira uma especialização válida.", false);
		}
		
		return new Leitura(str, true);
	}
	
	public Leitura lerDat() {
		Leitura ltr = this.lerString(true);
		if (!ltr.isOk()) {
			return ltr;
		}
		
		String str = ltr.getStr();
		
		try {
			LocalDate.parse(str);
		} catch (DateTimeParseException e) {
			return new Leitura("Insira a data de acordo com o formato aaaa-mm-dd (ano, mês, dia).", false);
		}
		
		return new Leitura(str, true);
	}
}