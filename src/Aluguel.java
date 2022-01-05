
public class Aluguel {
	private Quarto quarto;
	private String nome = "";
	private String email;
	
	
	
	public Aluguel(Quarto numQuarto, String nome, String email) {
		this.quarto = numQuarto;
		this.nome = nome;
		this.email =email;
	}
	
	public String getNome() {
		return(this.nome);
	}
	public String getEmail() {
		return(this.email);
	}
	public int getNumQuarto() {
		return this.quarto.getNumQuarto();
	}
	
	public String toString() {
		return ("\nName: "+this.getNome()+
				"\nEmail: " + this.getEmail()+
				"\nRoom: " + this.quarto.getNumQuarto());

	}
}
