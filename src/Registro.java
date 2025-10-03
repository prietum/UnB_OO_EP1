//manuseia consultas, internacoes, diagnosticos, planos

import java.util.HashMap;

public class Registro {
	HashMap<int, Paciente> pacientes = new HashMap<int, Paciente>();
	HashMap<int, Medico> medicos = new HashMap<int, Medico>();
	HashMap<int, Consulta> consultas = new HashMap<int, Consulta>();
	HashMap<int, Internacao> internacoes = new HashMap<int, Internacao>();
	HashMap<int, Diagnostico> diagnosticos = new HashMap<int, Diagnostico>();
	HashMap<int, Plano> planos = new HashMap<int, Plano>();
	HashMap<int, Quarto> quartos = new HashMap<int, Quarto>();
	
	////
	Paciente getPaciente(int cpf){return this.pacientes.get(cpf);}
	Medico getMedico(int cpf){return this.medicos.get(cpf);}
	Consulta getConsulta(int id){return this.consultas.get(id);}
	Internacao getInternacao(int id){return this.internacoes.get(id);}
	Diagnostico getDiagnostico(int id){return this.diagnosticos.get(id);}
	Plano getPlano(int id){return this.planos.get(id);}
	Quarto getQuarto(int id){return this.quartos.get(id);}
	
	////
	void addPaciente(int cpf, Paciente paciente) {
		this.pacientes.put(cpf, paciente);
	}
	
	void addMedico(int cpf, Medico medicos) {
		this.medicos.put(cpf, medicos);
	}
	
	void addConsulta(int id, Consulta consulta) {
		this.consultas.put(id, consulta);
	}
	
	void addInternacao(int id, Internacao internacao) {
		this.internacoes.put(id, internacao);
	}
	
	void addDiagnostico(int id, Diagnostico diagnostico) {
		this.diagnosticos.put(id, diagnostico);
	}
	
	void addPlano(int id, Plano plano) {
		this.planos.put(id, plano);
	}
	
	void addQuarto(int id, Quarto quarto) {
		this.quartos.put(id, quarto);
	}
	
	////
	void remPaciente(int cpf) {
		this.pacientes.remove(cpf);
	}
	
	void remMedico(int cpf) {
		this.medicos.remove(cpf);
	}
	
	void remConsulta(int id) {
		this.consultas.remove(id);
	}
	
	void remPlano(int id) {
		this.planos.remove(id);
	}
	
	void remQuarto(int id) {
		this.quartos.remove(id);
	}
	
	////
	@Override
	String toString(){
		String blobRegistro = "";
		
		blobRegistro = blobRegistro + "~ Pessoas ~\n";
		for (Paciente paciente : pacientes.values()) {
			blobRegistro = blobRegistro + "\t" + paciente.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n";
		for (Medico medico : medicos.values()) {
			blobRegistro = blobRegistro + medico.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Consultas ~\n";
		for (Consulta consulta : consultas.values()) {
			blobRegistro = blobRegistro + consulta.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Internações ~\n";
		for (Internacao internacao : internacoes.values()) {
			blobRegistro = blobRegistro + internacao.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Diagnósticos ~\n";
		for (Diagnostico diagnostico : diagnosticos.values()) {
			blobRegistro = blobRegistro + diagnostico.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Planos ~\n";
		for (Plano plano : planos.values()) {
			blobRegistro = blobRegistro + plano.toString() + "\n";
		}
		
		blobRegistro = blobRegistro + "\n~ Quartos ~\n";
		for (Quarto quarto : quartos.values()) {
			blobRegistro = blobRegistro + quarto.toString() + "\n";
		}
		
		return blobRegistro;
	}
}