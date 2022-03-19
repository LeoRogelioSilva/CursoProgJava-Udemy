import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Contribuinte;
import entities.Department;
import entities.HourContract;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import entities.Worker;
import entities_enum.WorkLevel;
import util.CurrencyConverter;

public class Main {

	public static void main(String[] args) throws ParseException {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		//ex7();
		//ex9();
		ex10();
		main(null);
	}
	
	public static void ex10() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int numOfTP;
		System.out.println("Enter the number of tax payers: ");
		numOfTP = sc.nextInt();
		List<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
		
		for(int i = 1; i <= numOfTP; i++) {
			String iOrC;
			System.out.printf("Tax payer #%d data:\n", i);
			System.out.println("Individual or company (i/c)? ");
			iOrC = sc.next();
			if(iOrC.equals("i")) {
				String name;
				Double anualIncome, healthExpenditures;
				
				System.out.println("Name: ");
				name = sc.next();
				System.out.println("Anual Income: ");
				anualIncome = sc.nextDouble();
				System.out.println("Health expenditures");
				healthExpenditures = sc.nextDouble();
				
				PessoaFisica pf = new PessoaFisica(name, anualIncome, healthExpenditures);
				pf.getTaxes();
				contribuintes.add(pf);
				
			}
			else if(iOrC.equals("c")) {
				String name;
				Double anualIncome, numberOfEmployees;
				
				System.out.println("Name: ");
				name = sc.next();
				System.out.println("Anual Income: ");
				anualIncome = sc.nextDouble();
				System.out.println("Number of Employees: ");
				numberOfEmployees = sc.nextDouble();
				
				PessoaJuridica pj = new PessoaJuridica(name, anualIncome, numberOfEmployees);
				pj.getTaxes();
				contribuintes.add(pj);
				
			}
			else {
				System.out.println("Invalid input");
			}
			
		}
		
		System.out.println("TAXES PAID:");
		Double totalTaxes=0.0;
		for(Contribuinte c : contribuintes) {
			System.out.printf("%s: $ %.2f\n", c.getName(), c.getTaxes());
			totalTaxes += c.getTaxes();
		}
		System.out.printf("TOTAL TAXES: $ %.2f\n", totalTaxes);
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void ex9() throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		
		String department, name;
		String workerLevel;
		Double baseSalary;
		Integer contracts;
		
		System.out.println("Enter Department's name: ");
		department = sc.next();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("\nLevel: ");
		workerLevel = sc.next();
		System.out.print("\nBase Salary: ");
		baseSalary = sc.nextDouble();
		System.out.print("\nHow many contracts to this worker? ");
		contracts = sc.nextInt();
		
		
		Worker worker = new Worker(name, WorkLevel.valueOf(workerLevel), baseSalary, new Department(department));
		
		for(int i = 1; i <= contracts; i++) {
			System.out.printf("Enter contract #%d data:\n", i);
			String date;
			Double valuePerHour;
			Integer duration;
			
			System.out.print("Date (DD/MM/YYYY): ");
			date = sc.next();
			System.out.print("\nValue per Hour: ");
			valuePerHour =sc.nextDouble();
			System.out.print("\nDuration (Hours): ");
			duration =sc.nextInt();
			HourContract contract = new HourContract(sdf.parse(date), valuePerHour, duration);
			worker.addContract(contract);		
			
		}
		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		String enterDate = sc.next();

		int month = Integer.parseInt(enterDate.substring(0,2));
		int year = Integer.parseInt(enterDate.substring(3));
		
		System.out.println("Name: "+worker.getName()+"\nDepartment: "+worker.getDepartment().getName()+"\nIncome for "+enterDate+": "+ String.format("%.2f", worker.income(year, month)) );
		
		
		sc.close();
	}
	
	public static void ex8() {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		int x,y;
		x=sc.nextInt();
		y=sc.nextInt();
		
		int[][] mat = new int[x][y];
		
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
				
			}
			System.out.println();
		}
		int busca = sc.nextInt();
		
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				if(mat[i][j]==busca) {
					System.out.printf("Position %d,%d:\n", i,j);
					if(j!=0) {
						System.out.println("Left: "+mat[i][j-1]);
					}
					if(j<x-1) {
						System.out.println("Right: "+mat[i][j+1]);
					}
					if(i<y-1) {
						System.out.println("Down: "+mat[i+1][j]);
					}
					if(i!=0) {
						System.out.println("Up: "+mat[i-1][j]);
					}
				}
					
			}
		}
		
		sc.close();
		
	}
	
	public static void ex7() {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Input: ");
		int i = sc.nextInt();
		int neg = 0;
		
		int[][] mat = new int[i][i];
		
		for(int x = 0; x<i;x++) {
			for(int y=0;y<i;y++) {
				mat[x][y] = sc.nextInt();
				if(mat[x][y]<0)
					neg++;
			}
		}
		
		System.out.println("Main diagonal: ");
		for(int x = 0; x<i; x++)
			System.out.printf("%d ", mat[x][x]);
		System.out.println("\nNegative Numbers: "+neg);
		sc.close();
	}
	
	public static void ex6() {
		Scanner sc1 = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("How many employees will be registered?");
		
		int n;
		n = sc1.nextInt();
		
		List<Employee> funcionarios = new ArrayList<>();
		

		for(int i =0; i<n; i++) {
			System.out.printf("Employee #%d:\n", i+1);
			int id;
			String name;
			double salary;
			
			System.out.println("Id: ");
			id=sc1.nextInt();
			System.out.println("Name: ");
			name=sc1.next();
			System.out.println("Salary: ");
			salary = sc1.nextDouble();
			Employee aux = new Employee(id, name, salary);
			funcionarios.add(aux);
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int id = sc1.nextInt();
		System.out.println("Enter the percentage: ");
		double perc = sc1.nextDouble();

		
		Employee salarioNovo = funcionarios.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
		
		salarioNovo.setSalary(perc);
		
		System.out.println("List of Employees: ");
		for(Employee x : funcionarios) {
			System.out.printf("%d, %s, %.2f\n", x.getId(), x.getName(), x.getSalary());
		}
		
		
		
		sc1.close();
	}
	
	public static void ex5() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		Quarto[] quartos = new Quarto[10];
		
		for(int i =0; i<10; i++) {
			quartos[i] = new Quarto(i);
		}
		
		
		System.out.println("How many rooms will be rented?");
		 
		int resp = sc.nextInt();
		
		Aluguel[] alugueis = new Aluguel[resp];
		
		for(int i = 0; i< resp; i++) {
			System.out.println("\nRent #"+(i+1)+":");
			System.out.print("Name: ");
			String nome = sc.next();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Room: ");
			int quarto = sc.nextInt();
			
			for(int j = 0; j<10; j++) {
				if(quartos[j].getNumQuarto()==quarto && quartos[j].getStatus()==0) {
					quartos[j].setStatus();
					alugueis[i] = new Aluguel(quartos[j],nome, email);
					continue;
				}
			}
			try{
				@SuppressWarnings("unused")
				String teste = alugueis[i].getEmail();
			}
			catch(NullPointerException nexc){
				System.out.println("Quarto indisponível");
				return;
			}
			
			
			
			
			
		}
		System.out.println("\nBusy Rooms: ");
		for(int i = 0; i<alugueis.length;i++) {
			
		}
		
		
		sc.close();
	}
	
	public static void ex4() {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		Account conta;
		
		System.out.print("\nEnter account number: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("\nEnter account holder: ");
		String nomeConta = sc.next();
		
		System.out.print("\nIs there a initial deposit (y/n)? ");
		String resp = sc.next();
		if(resp.equals("y")) {
			System.out.print("\nEnter initial deposit value: ");
			double valorInicial= sc.nextDouble();
			conta = new Account(numeroConta, nomeConta, valorInicial);
		}
		else {
			conta = new Account(numeroConta, nomeConta);
		}
		
		
		System.out.println("Account data:");
		System.out.println(conta.toString());
		
		System.out.print("\nEnter a deposit value: ");
		double valor = sc.nextDouble();
		
		conta.deposito(valor);
		System.out.println("Updated Account data:");
		System.out.println(conta.toString());
		
		System.out.print("\nEnter a withdraw value: ");
		valor = sc.nextDouble();
		
		conta.saque(valor);
		System.out.println("Updated Account data:");
		System.out.println(conta.toString());
		
		sc.close();
		}
	
	public static void ex3() {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("What is the dollar price? ");
		double dolar = sc.nextDouble();
		
		System.out.println("How many dollars will de bought? ");
		double amount = sc.nextDouble();
		
		System.out.printf("Amount to be paid in reais = %.2f", CurrencyConverter.calc(dolar, amount));
		
		sc.close();
	}
	
	public static void ex2() {
		Scanner sc = new Scanner(System.in);
		
		Locale.setDefault(Locale.US);
		
		Student a = new Student();
		
		a.setName(sc.next());
		a.setNota1(sc.nextDouble());
		a.setNota2(sc.nextDouble());
		a.setNota3(sc.nextDouble());
		
		System.out.println("FINAL GRADE = " + a.notaFinal());
		if(a.notaFinal()>=60.0) {
			System.out.println("PASS");
		}
		sc.close();	
	}
}

	