public class Cpf {
	private int digitos;
	
	Cpf(int digitos) {
		this.digitos = digitos;
	}
	
	public int getInt() {
		return this.digitos;
	}
	
	@Override
	public String toString() {
		String str = Integer.toString(this.digitos);
		return String.format(
			"%s.%s.%s-%s", 
			str.substring(1,3), str.substring(4,6), str.substring(7,9), str.substring(10,11));
	}
}
