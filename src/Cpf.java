public class Cpf {
	private Seq digitos;
	
	Cpf(Seq digitos) {
		this.digitos = digitos;
	}
	
	public Seq getSeq(){return this.digitos;}
	
	@Override
	public String toString() {
		String str = this.digitos.toString();
		return String.format(
			"%s.%s.%s-%s", 
			str.substring(0,3), str.substring(3,6), str.substring(6,9), str.substring(9,11));
	}
}