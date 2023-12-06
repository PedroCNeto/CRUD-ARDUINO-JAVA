
public class Composicao {
	
	private int IDcomp;
	private String IDComponente;
	private String IDKit;
	private String nomeComponente;
	private String nomeKit;
	private int quantidade;
	
	public int getIDcomp() {
		return IDcomp;
	}
	public void setIDcomp(int iDcomp) {
		IDcomp = iDcomp;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getIDComponente() {
		return IDComponente;
	}
	public void setIDComponente(String iDComponente) {
		IDComponente = iDComponente;
	}
	public String getIDKit() {
		return IDKit;
	}
	public void setIDKit(String iDKit) {
		IDKit = iDKit;
	}
	public String getNomeComponente() {
		return nomeComponente;
	}
	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
	public String getNomeKit() {
		return nomeKit;
	}
	public void setNomeKit(String nomeKit) {
		this.nomeKit = nomeKit;
	}
}
