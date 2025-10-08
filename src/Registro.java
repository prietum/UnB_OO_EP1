//manuseia consultas, internacoes, diagnosticos, planos

import java.util.HashMap;
import java.util.ArrayList;

public class Registro {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Medico> medicos = new HashMap<String, Medico>();
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();				
	ArrayList<Internacao> internacoes = new ArrayList<Internacao>();
	ArrayList<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
	HashMap<Integer, Plano> planos = new HashMap<Integer, Plano>();
	HashMap<Integer, Quarto> quartos = new HashMap<Integer, Quarto>();
	
	////
	Paciente getPaciente(String cpf)		{return this.pacientes.get(cpf);}
	Medico getMedico(String cpf)			{return this.medicos.get(cpf);}
	Consulta getConsulta(int id)		{return this.consultas.get(id);}
	Internacao getInternacao(int id)	{return this.internacoes.get(id);}
	Diagnostico getDiagnostico(int id)	{return this.diagnosticos.get(id);}
	Plano getPlano(int id)				{return this.planos.get(id);}
	Quarto getQuarto(int id)			{return this.quartos.get(id);}
	
	////
	void putPaciente(Paciente paciente) 			{this.pacientes.put(paciente.getCpf().getSeq().toString(), paciente);}
	void putMedico(Medico medico) 					{this.medicos.put(medico.getCpf().getSeq().toString(), medico);}
	void addConsulta(Consulta consulta) 			{this.consultas.add(consulta);}
	void addInternacao(Internacao internacao) 		{this.internacoes.add(internacao);}
	void addDiagnostico(Diagnostico diagnostico)	{this.diagnosticos.add(diagnostico);}
	void putPlano(Plano plano) 						{this.planos.put(plano.getId(), plano);}
	void putQuarto(Quarto quarto) 					{this.quartos.put(quarto.getId(), quarto);}
	
	////
	int getPacientesSize() 		{return this.pacientes.size();}
	int getMedicosSize() 		{return this.medicos.size();}
	int getConsultasSize() 		{return this.consultas.size();}
	int getInternacoesSize() 	{return this.internacoes.size();}
	int getDiagnosticosSize() 	{return this.diagnosticos.size();}
	int getPlanosSize() 			{return this.planos.size();}
	int getQuartosSize() 		{return this.quartos.size();}
	
	////
	public String toStringPacientes(){
		String blob = "~ Pacientes ~\n";
		for (Paciente paciente : pacientes.values()) {
			blob = blob + paciente.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringMedicos(){
		String blob = "~ Médicos ~\n";
		for (Medico medico : medicos.values()) {
			blob = blob + medico.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringConsultas(){
		String blob = "\n~ Consultas ~\n";
		for (int i = 0; i < consultas.size(); i++) {
			blob = blob + String.format("nº%d", i) + consultas.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringInternacoes(){
		String blob = "\n~ Internações ~\n";
		for (int i = 0; i < internacoes.size(); i++) {
			blob = blob + String.format("nº%d", i) + internacoes.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringDiagnosticos(){
		String blob = "\n~ Diagnósticos ~\n";
		for (int i = 0; i < diagnosticos.size(); i++) {
			blob = blob + String.format("nº%d", i) + diagnosticos.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringPlanos(){
		String blob = "\n~ Planos ~\n";
		for (Plano plano : planos.values()) {
			blob = blob + plano.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringQuartos(){
		String blob = "\n~ Quartos ~\n";
		for (Quarto quarto : quartos.values()) {
			blob = blob + quarto.toString() + "\n\n";
		}
		return blob;
	}
	
	@Override
	public String toString(){
		String blob = "";
		
		blob = blob + this.toStringPacientes() + "\n";
		blob = blob + this.toStringMedicos() + "\n";
		blob = blob + this.toStringConsultas() + "\n";
		blob = blob + this.toStringInternacoes() + "\n";
		blob = blob + this.toStringDiagnosticos() + "\n";
		blob = blob + this.toStringPlanos() + "\n";
		blob = blob + this.toStringQuartos() + "\n";
		
		return blob;
	}
}