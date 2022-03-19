package entities;

public class PessoaJuridica extends Contribuinte{
	private Double numerOfEmployees;
	
	public PessoaJuridica(String name, Double anualIncome, Double numerOfEmployees) {
		super();
		this.numerOfEmployees = numerOfEmployees;
		this.name = name;
		this.anualIncome = anualIncome;
	}
	
	public Double getNumerOfEmployees() {
		return numerOfEmployees;
	}

	public void setNumerOfEmployees(Double numerOfEmployees) {
		this.numerOfEmployees = numerOfEmployees;
	}

	@Override
	public Double calcTaxes(Double anualIncome) {
		Double taxes;
		
		taxes = this.numerOfEmployees>10?this.anualIncome*0.16:this.anualIncome*0.14;
		
		return taxes;
	}
}
