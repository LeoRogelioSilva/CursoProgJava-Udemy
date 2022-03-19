package entities;

public class PessoaFisica extends Contribuinte{
	private Double healthExpenditures;
	
	public PessoaFisica(String name, Double anualIncome, Double healthExpenditures) {
		super();
		this.healthExpenditures = healthExpenditures;
		this.name = name;
		this.anualIncome = anualIncome;
	}
	
	

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}
	
	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public Double getTaxes() {
		this.taxes = this.getAnualIncome() < 20000 ? this.getAnualIncome() * 0.15 - this.getHealthExpenditures() / 2 : this.getAnualIncome() * 0.25 - this.getHealthExpenditures() / 2;	
		setTaxes(taxes);
		return this.taxes;
	}


}
