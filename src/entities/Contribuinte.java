package entities;

public abstract class Contribuinte {
	protected String name;
	protected Double anualIncome;
	protected Double taxes;
	
	

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
	
	public abstract Double getTaxes();


	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}


}
