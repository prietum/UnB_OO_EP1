import java.util.Optional;

public class Quarto {
	private int id;
	private Optional<Paciente> optPac;
	
	Quarto(int id) {
		this.id = id;
	}
	
	//é estranho misturar inglês com português
	boolean isOcupado(){
		return this.optPac.isPresent();
	}
	
	void setPacienteOcupante(Optional<Paciente> optPac){
		this.optPac = optPac;
	}
	
	public int getId(){return this.id;}
	
	@Override
	public String toString(){
		String blobOptPac;
		if (this.isOcupado()){
			blobOptPac = this.optPac.get().getNome();
		} else {
			blobOptPac = "Vazio";
		}
		
		return String.format(
			"Qt. nº%02i - %s", this.id, blobOptPac
			
		);
	}
}