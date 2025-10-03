//manuseia consultas, internacoes, diagnosticos, planos

import java.util.HashMap;

public class Registro {
	HashMap<int, Paciente> pacientes = new HashMap<int, Paciente>();
	HashMap<int, Medico> medicos = new HashMap<int, Medico>();
	HashMap<int, Consulta> consultas = new HashMap<int, Consulta>();
	HashMap<int, Internacao> internacoes = new HashMap<int, Internacao>();
	HashMap<int, Diagnostico> diagnosticos = new HashMap<int, Diagnostico>();
	HashMap<int, Plano> planos = new HashMap<int, Plano>();
	
	////
	Paciente getPaciente(int cpf){return this.pacientes.get(cpf);}
	Paciente getMedico(int cpf){return this.medicos.get(cpf);}
	Paciente getConsulta(int id){return this.consultas.get(id);}
	Paciente getInternacao(int id){return this.internacoes.get(id);}
	Paciente getDiagnostico(int id){return this.diagnosticos.get(id);}
	
	////
	void addPaciente(int cpf, Paciente paciente) {
		
	}
	
	void addMedico(int cpf, Medico medicos) {
		
	}
	
	void addConsulta(int id, Consulta consultas) {
		
	}
	
	void addInternacao(int id, Internacao internacoes) {
		
	}
	
	void addDiagnostico(int id, Diagnostico diagnosticos) {
		
	}
	
	////
	void remPaciente(int cpf) {
		
	}
	
	void remMedico(int cpf) {
		
	}
	
	void remConsulta(int id) {
		
	}
	
	void remInternacao(int id) {
		
	}
	
	void remDiagnostico(int id) {
		
	}
	
	////
	@Override
	String toString(){
		String blobRegistro = "";
		
		blobRegistro = blobRegistro + "~ Pessoas ~\n";
		for (Paciente paciente : pacientes.values()) {
			blobPessoas = blobPessoas + "\t" + paciente.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n";
		for (Medico medico : medicos.values()) {
			blobPessoas = blobPessoas + medico.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Consultas ~\n";
		for (Consulta consulta : consultas.values()) {
			blobConsultas = blobConsultas + consulta.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Internações ~\n";
		for (Internacao internacao : internacoes.values()) {
			blobInternacoes = blobInternacoes + internacao.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Diagnósticos ~\n";
		for (Diagnostico diagnostico : diagnosticos.values()) {
			blobDiagnosticos = blobDiagnosticos + diagnostico.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Planos ~\n";
		for (Plano plano : planos.values()) {
			blobPlanos = blobPlanos + plano.toString() + "\n";
		}
		
		return blobRegistro;
	}
}