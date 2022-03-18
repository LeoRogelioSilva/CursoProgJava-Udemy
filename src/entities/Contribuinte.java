package entities;

public abstract class Contribuinte {
	protected String name;
	protected Double anualIncome;
	private Double taxes;
	
	

	public Contribuinte() {
		
	}
	
	
	public Contribuinte(String name, Double anualIncome) {
		super();
		
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getAnualIncome() {
		return anualIncome;
	}


	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public Double getTaxes() {
		return taxes;
	}


	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}


	public abstract Double calcTaxes(Double anualIncome);
}
