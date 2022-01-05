package util;

public class CurrencyConverter {
	public static double calc(double dolar, double amount) {
		return dolar * amount + (dolar*amount)*0.06;
	}
	
}
