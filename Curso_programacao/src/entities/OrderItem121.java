package entities;

public class OrderItem121 {
	private Integer quantity;
	private Double price;
	
	public OrderItem121() {
		
	}

	public OrderItem121(Integer quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return (quantity*price);
	}
	
}
