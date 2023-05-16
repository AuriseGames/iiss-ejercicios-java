import java.util.Scanner;

import es.uca.iiss.aspectj.Bank;

public class Main {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {
		
		System.out.println("AspectJ Bank");
		System.out.println("------------");
		System.out.println("1 - Create user");
		System.out.println("2 - Make transaction");
		System.out.println("3 - Take money out");
		System.out.println("4 - Show users");
		System.out.println("5  - Exit");
		
		int option = Integer.valueOf(input.nextLine());
		Bank bank = new Bank();
		
		switch(option) {
		case 1:
			bank.createUser();
			break;
		case 2:
			bank.makeTransaction();
			break;
		case 3:
			bank.takeMoneyOut();
			break;
		case 4:
			bank.showUsers();
			break;
		case 5:
			System.out.println("Exiting..");
			break;
		}
	}
	
}
