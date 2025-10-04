abstract class Pessoa {
	private String nome;
	private int cpf;
	private int idade;
	
	boolean verifyNome(String a) {
		return a.length() > 0;
	}
	
	boolean verifyCpf(int a) {
		return Integer.toString(a).length() == 11;
	}
	
	boolean verifyIdade(int a) {
		return a >= 0 && a <= 120;
	}
	
	String getNome(){return nome;}
	void setNome(String nome){this.nome = nome;}
	int getIntCpf(){return cpf;}
	void setCpf(int cpf){this.cpf = cpf;}
	int getIdade(){return idade;}
	void setIdade(int idade){this.idade = idade;}
	
	String getStringCpf(){
		String str = Integer.toString(this.cpf);
		return String.format(
			"%s.%s.%s-%s", 
			str.substring(1,3), str.substring(4,6), str.substring(7,9), str.substring(10,11));
		}
}