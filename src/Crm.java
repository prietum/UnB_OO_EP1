public class CRM {
	private int digitos;
	private UF uf;
	
	CRM(int digitos, UF uf){
		this.digitos = digitos;
		this.uf = uf;
	}
	
	@Override
	String toString(){return String.format("%i-%s", this.digitos, this.uf);}
}