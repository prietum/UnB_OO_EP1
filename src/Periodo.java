//registra período entre dois dias, sem horário específico

public class Periodo {
	private int t0;
	private int t1;
	
	Periodo(double t0, double t1) {
		this.t0 = t0;
		this.t1  t1;
	}
	
	public boolean verifyHor(double t0, double t1) {
		return (t0 < t1);
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