//objeto que representa uma string composta somente por números.

public class Seq {
	private String str;
	
	Seq(String str) throws NumberFormatException {
		for (int i = 0; i < str.length(); i++) {
			try {
				Integer.parseInt(str.substring(i,i+1));
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Um dos caracteres não é número.");
			}
		}
		
		this.str = str;
	}
	
	@Override
	public String toString(){return this.str;}
	public Float toFloat(){return Float.valueOf(this.str);}
}