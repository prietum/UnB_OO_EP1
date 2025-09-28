public class PacienteEspecial extends Paciente {
	
	Plano getPlano() {
		return Registro.getPlano(this.getNome());
	}
	
}