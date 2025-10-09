//manuseia consultas, internacoes, diagnosticos, planos

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.nio.file.StandardOpenOption.*;
import java.nio.charset.Charset;
import java.io.IOException;
import java.time.*;

public class Registro {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Medico> medicos = new HashMap<String, Medico>();
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();				
	ArrayList<Internacao> internacoes = new ArrayList<Internacao>();
	ArrayList<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
	HashMap<Integer, Plano> planos = new HashMap<Integer, Plano>();
	HashMap<Integer, Quarto> quartos = new HashMap<Integer, Quarto>();
	
	////
	Paciente getPaciente(String cpf)	{return this.pacientes.get(cpf);}
	Medico getMedico(String cpf)		{return this.medicos.get(cpf);}
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
	int getPlanosSize() 		{return this.planos.size();}
	int getQuartosSize() 		{return this.quartos.size();}
	
	////
	public String toStringPacientes(){
		String blob = String.format("~ Pacientes (%d)~\n", pacientes.size());
		for (Paciente paciente : pacientes.values()) {
			blob = blob + paciente.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringMedicos(){
		String blob = String.format("~ Médicos (%d) ~\n", medicos.size());
		for (Medico medico : medicos.values()) {
			blob = blob + medico.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringConsultas(){
		String blob = String.format("\n~ Consultas (%d) ~\n", consultas.size());
		for (int i = 0; i < consultas.size(); i++) {
			blob = blob + String.format("nº%d", i+1) + consultas.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringInternacoes(){
		String blob = String.format("\n~ Internações (%d)~\n",internacoes.size());
		for (int i = 0; i < internacoes.size(); i++) {
			blob = blob + String.format("nº%d", i+1) + internacoes.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringDiagnosticos(){
		String blob = String.format("\n~ Diagnósticos (%d) ~\n", diagnosticos.size());
		for (int i = 0; i < diagnosticos.size(); i++) {
			blob = blob + String.format("nº%d", i+1) + diagnosticos.get(i).toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringPlanos(){
		String blob = String.format("\n~ Planos (%d) ~\n", planos.size());
		for (Plano plano : planos.values()) {
			blob = blob + plano.toString() + "\n\n";
		}
		return blob;
	}
	
	public String toStringQuartos(){
		String blob = String.format("\n~ Quartos (%d) ~\n", quartos.size());
		for (Quarto quarto : quartos.values()) {
			blob = blob + quarto.toString() + "\n\n";
		}
		return blob;
	}
	
	private Path projPath;
	private Path dataPath;
	private Path expoPath;
	
	//carregar dados no construtor
	Registro(){
		
		//pega o sistema de arquivos padrão
		FileSystem fs = FileSystems.getDefault();
		System.out.println("File System = " + fs);
		
		//pega o endereço da pasta de trabalho /projeto/bin
		String binPathString = System.getProperty("user.dir");
		System.out.println("Working Directory = " + binPathString);
		
		//transforma a string em Path
		Path binPath = fs.getPath(binPathString);
		System.out.println(binPath);
		
		//sobe um nível, /projeto
		this.projPath = binPath.getParent();
		System.out.println(projPath);
		
		//desce um nível, /projeto/data.csv, /projeto/export.csv
		this.dataPath = projPath.resolve("data.csv");
		System.out.println(dataPath);
		
		this.expoPath = projPath.resolve("export.csv");
		System.out.println(expoPath);
		
		//verifica se existe /projeto/data.csv, lê se existe e cria se não existir
		if (Files.exists(dataPath)) {
			//lê /projeto/data.csv
			
			System.out.println("Arquivo data.csv encontrado.");
			
			try {
				BufferedReader br = Files.newBufferedReader(dataPath);
				
				List<List<String>> argsLines = br.lines()
					.map(n -> Arrays.<String>asList(n.split("[,]")))
					.collect(Collectors.toList());
				
				System.out.println(String.format("Carregando %d linhas...\n", argsLines.size()));
				
				for(int i = 0; i < argsLines.size(); i++) {
					String[] args = argsLines.get(i).toArray(new String[0]);
					
					System.out.println(String.format("Carregando linha %d: %s", i+1, Arrays.toString(args)));
					
					try {
						switch (args[0]) {
							case "paciente":
								if (args.length == 5) { // tem plano
									if (this.getPlano(Integer.valueOf(args[4]))==null) {continue;}
								
									this.putPaciente(new PacienteEspecial(
										args[1], new Cpf(new Seq(args[2])), Integer.parseInt(args[3]), this.getPlano(Integer.valueOf(args[4]))
									));
								} else { // nao tem plano
									this.putPaciente(new Paciente(
										args[1], new Cpf(new Seq(args[2])), Integer.parseInt(args[3])
									));
								}
								break;
							case "medico":
								this.putMedico(new Medico(
									args[1], new Cpf(new Seq(args[2])), Integer.parseInt(args[3]),
									new Crm(args[4]), Especializacao.valueOf(args[5]), 
									Float.valueOf(args[6]), new Horario(Integer.valueOf(args[7]),Integer.valueOf(args[8]))
								));
								break;
							case "consulta":
								if (this.getMedico(args[1]) == null || this.getPaciente(args[2]) == null) {continue;}
								
								this.addConsulta(new Consulta(
									this.getMedico(args[1]), this.getPaciente(args[2]), LocalDate.parse(args[3]), new Status(Integer.valueOf(args[4]))
								));
								break;
							case "internacao":
								if (this.getMedico(args[1]) == null || this.getPaciente(args[2]) == null) {continue;}
							
								this.addInternacao(new Internacao(
									this.getMedico(args[1]), this.getPaciente(args[2]), new Periodo(LocalDate.parse(args[3]), LocalDate.parse(args[4])), 
									this.getQuarto(Integer.valueOf(args[5])), new Status(Integer.valueOf(args[6]))
								));
								break;
							case "diagnostico":
								if (this.getMedico(args[1]) == null || this.getPaciente(args[2]) == null) {continue;}
							
								this.addDiagnostico(new Diagnostico(
									this.getMedico(args[1]), this.getPaciente(args[2]), LocalDate.parse(args[3]), args[4], args[5]
								));
								break;
							case "quarto":
								this.putQuarto(new Quarto(
									Integer.valueOf(args[1])
								));
								break;
							case "plano":
								this.putPlano(new Plano(
									Integer.valueOf(args[1]), args[2], Float.valueOf(args[3]), Float.valueOf(args[4])
								));
								break;
						}
						System.out.println(String.format("Sucesso ao carregar linha %d\n.", i+1));
					} catch (Exception e) {
						System.out.println(String.format("Falha ao carregar linha %d.\n%s\n", i+1, e.getMessage()));
					}
				}
				
			} catch (IOException e) { // << verificar
				System.out.println("que");
			} catch (SecurityException e) {
				System.out.println("ham");
			}
		} else {
			//cria /projeto/data.csv
			
			System.out.println("Arquivo data.csv não encontrado.");
			
			try {
				BufferedWriter bw = Files.newBufferedWriter(dataPath, Charset.forName("ISO-8859-1"), CREATE);
				bw.close();
			} catch (IOException e) {
				System.out.println("que");
			} catch (SecurityException e) {
				System.out.println("ham");
			}
		}
		
	};
	
	/* private void writeLine(BufferedWriter bw, String s){
		for (int i = 0, i < s.length, i++) {
			bw.write(s.charAt(i));
		}
		bw.newLine();
	}
	
	private void writePath(Path p){
		try {
			BufferedWriter bw = Files.newBufferedWriter(p, Charset.forName("ISO-8859-1"), CREATE, APPEND);
			
			for (Quarto qua : this.quartos.values()){
				String n = "quarto,";
				String m = String.format("%d", qua.getId());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (Plano pla : this.planos.values()){
				String n = "plano,";
				String m = String.format("%d,%s,%f%f", qua.getId(), qua.getNome(), qua.getDesco(), qua.getCusto());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (Paciente pac : this.pacientes.values()){
				String n = "paciente,";
				String m = String.format("%s,%s,%d", pac.getNome(), pac.getCpf().getSeq().toString(), pac.getIdade());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (Medico med : this.medicos.values()){
				String n = "medico,";
				String m = String.format("%s,%s,%d,%s,%s,%f,%d,%d", med.getNome(), med.getCpf().getSeq().toString(), med.getIdade(), med.getCrm().getStr(), med.getEsp().name(), med.getCusto(), med.getHor().getT0(), med.getHor().getT1());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (int i = 0; i < this.getConsultasSize(); i++){
				Consulta cons = this.getConsulta(i);
				
				String n = "consulta,";
				String m = String.format("%s,%s,%s,%i", cons.getMed().getCpf().getSeq().toString(), cons.getPac().getCpf().getSeq().toString(), cons.getDat().toString(), cons.getStatus().getInt());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (int i = 0; i < this.getDiagnosticosSize(); i++){
				Diagnostico diag = this.getDiagnostico(i);
				
				String n = "diagnostico,";
				String m = String.format("%s,%s,%s,%i", diag.getMed().getCpf().getSeq().toString(), diag.getPac().getCpf().getSeq().toString(), diag.getDat().toString(), diag.getStatus().getInt());
				n = n + m;
				writeLine(bw, n);
			}
			
			for (int i = 0; i < this.getInternacoesSize(); i++){
				String n = "internacao,";
				String m = String.format("%d,%s,%f%f", qua.getId(), qua.getNome(), qua.getDesco(), qua.getCusto());
				n = n + m;
				writeLine(bw, n);
			}
			
			bw.close();
			
		} catch (IOException e) {
			System.out.println("que");
		} catch (SecurityException e) {
			System.out.println("ham");
		}
	}
	
	public void salvar(){
		writePath(this.dataPath);
	}
	
	public void exportar(){
		writePath(this.expoPath);
	} */
	
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