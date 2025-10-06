// serve para avaliar se os valores inseridos pelo usuário são válidos ou não

public class Leitura {
	private int ctt_int;
	private String ctt_str;
	private boolean ctt_boo;
	
	private boolean ok;
	
	public int getInt() {
		return this.ctt_int;
	}
	
	public String getStr() {
		return this.ctt_str;
	}
	
	public boolean getBoo() {
		return this.ctt_boo;
	}
	
	public boolean isOk(){
		return this.ok;
	}
	
	Leitura(int ctt, boolean ok) {
		this.ok = ok;
		this.ctt_int = ctt;
	}
	
	Leitura(String ctt, boolean ok) {
		this.ok = ok;
		this.ctt_str = ctt;
	}
	
	Leitura(boolean ctt, boolean ok) {
		this.ok = ok;
		this.ctt_boo = ctt;
	}
}