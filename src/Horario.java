//registra dia e horário > 1h quaisquer

public class Horario {
	private Dia dia;
	private int t0; 
	private int t1;
	
	Horario(Dia dia, int t0, int t1) {
		this.dia = dia;
		this.t0 = t0;
		this.t1  t1;
	}
	
	public boolean verifyHor(int t0, int t1) {
		return (t0 < t1) && (t0 >= 0) && (t1 >= 1) && (t0 <= 23) and (t1 <= 24);
	}
	
	public String getCodigo() {
		return String.format("%i%02i%02i",
			this.dia.toInt(), this.t0, this.t1
		);
	}
	public String getExtenso() {
		return String.format("%s, %02i:00 - %02i:00.",
			this.dia.toString(), this.t0, this.t1
		);
	}
}