package beans;

public class Dados {
	
	private String cepOrigem;
	private String cepDestino;
	private String email;
	private ServicoCorreios servicoCorreios;
	private String cupomDesconto;
	
	
	public String getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	public String getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ServicoCorreios getServicoCorreios() {
		return servicoCorreios;
	}
	public void setServicoCorreios(ServicoCorreios servicoCorreios) {
		this.servicoCorreios = servicoCorreios;
	}
	public String getCupomDesconto() {
		return cupomDesconto;
	}
	public void setCupomDesconto(String cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}
	
	
	

}
