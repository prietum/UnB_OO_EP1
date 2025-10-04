public class Crm {
	private int digitos;
	private UF uf;
	
	Crm(int digitos, UF uf){
		this.digitos = digitos;
		this.uf = uf;
	}
	
	@Override
	public String toString(){return String.format("%i-%s", this.digitos, this.uf);}
}