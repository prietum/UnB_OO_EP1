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
	
	int setPacienteOcupante(Paciente pac){
		//retorna 0 se ok
		//retorna 1 se já está ocupado
		
		if (!this.isOcupado()) {
			return 1;
		} else {
			this.optPac = new Optional.of(pac);
			return 0;
		}
	}
	
	@Override
	public String toString(){
		String blobOptPac;
		if (this.isOcupado){
			blobOptPac = this.optPac.get()
		} else {
			blobOptPac = "Vazio"
		}
		
		return String.format(
			"Qt. nº%02i - %s", this.id, blobOptPac
			
		);
	}
}