public class PacienteEspecial extends Paciente {
	
	private int idPlano;
	
	Plano getPlano() {
		return Registro.getPlano(this.idPlano);
	}
}