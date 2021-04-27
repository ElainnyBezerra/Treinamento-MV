package entidade;

public class ContaCorrente extends Conta {
	
	private double taxa;

	public void sacar(double valor) {
		this.setSaldo(this.getSaldo() - (valor + this.getTaxa()));
	}
	
	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
}
