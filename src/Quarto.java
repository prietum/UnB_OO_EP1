import java.util.Optional;

public class Quarto {
	private int id;
	
	Quarto(int id) {
		this.id = id;
	}
	
	public int getId(){return this.id;}
	
	@Override
	public String toString(){
		return String.format("Qt. nº%02d", this.id);
	}
}