public class Crm {
	private int digitos;
	private UF uf;
	
	Crm(int digitos, UF uf){
		this.digitos = digitos;
		this.uf = uf;
	}
	
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
	
	@Override
	public String toString(){return String.format("%i-%s", this.digitos, this.uf);}
}