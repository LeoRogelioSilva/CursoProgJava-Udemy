
public class Account {
	private int numeroConta;
	private String nomeTitular;
	private double saldo;
	
	public Account(int numeroConta, String nomeTitular, double saldo) {
		this.setNumeroConta(numeroConta);
		this.setNomeTitular(nomeTitular);
		this.setSaldo(saldo);
	}
	public Account(int numeroConta, String nomeTitular) {
		this.setNumeroConta(numeroConta);
		this.setNomeTitular(nomeTitular);
	}
	
	public void saque(double valor) {
		this.saldo -= valor + 5;
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	private void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return("Account "+this.getNumeroConta()+", Holder: "+this.getNomeTitular()+", Balance: "+this.getSaldo());
	}
	
}
