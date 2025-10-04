//registra dia e horário > 1h quaisquer

public class Horario {
	private int t0; 
	private int t1;
	
	Horario(int t0, int t1) {
		this.t0 = t0;
		this.t1 = t1;
	}
	
	public boolean verifyHor(int t0, int t1) {
		return (t0 < t1) && (t0 >= 0) && (t1 >= 1) && (t0 <= 23) && (t1 <= 24);
	}
	
	@Override
	public String toString() {
		return String.format(
			"%02i:00 - %02i:00.",
			this.t0, this.t1
		);
	}
}