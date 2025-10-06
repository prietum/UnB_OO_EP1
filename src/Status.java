public class Status {
	private int i;
	
	Status(int i) {
		this.i = i;
	}
	
	public int getInt() {return this.i;}
	
	public void setConcluido() {this.i = 1;}
	public void setCancelado() {this.i = 2;}
	
	@Override
	public String toString() {
		switch (this.i) {
			case 0: return "Agendada";
			case 1: return "Concluída";
			case 2: return "Cancelada";
			default: return "???";
		}
	}
}