public class Crm {
	private Seq digitos;
	private UF uf;
	
	Crm(String str){
		Seq digitos = new Seq(str.substring(0,6));
		UF uf = UF.valueOf(str.substring(6,8));
		
		this.digitos = digitos;
		this.uf = uf;
	}
	
	public Seq getSeq(){return this.digitos;}
	public UF getUf(){return this.uf;}
	
	/* public boolean verifyLength(String crm) {
		return crm.length() == 8;
	}
	
	public boolean verifyIntPart(String crm) {
		try {
			Integer.parseInt(crm.substring(1,6));
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public boolean verifyUfPart(String crm) {
		try {
			UF.valueOf(crm.substring(7,8));
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	} */
	
	public String getStr(){return String.format("%s%s", this.digitos.toString(), this.uf.name());}
	
	@Override
	public String toString(){return String.format("%s-%s", this.digitos.toString(), this.uf.name());}
}