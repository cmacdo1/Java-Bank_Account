import java.util.Scanner;

public class TransferTest
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		Account acct1 = new Account(1000, "Jack");
		Account acct2 = new Account(1000, "Jill");
		int choice = 0;
		
		do
		{
			// show menu
			System.out.println("\nMenu\n");
			System.out.println("1) Transfer from acct1 to acct2");
			System.out.println("2) Transfer from acct2 to acct1");
			System.out.println("3) Exit");
			
			// get choice
			System.out.print("\nEnter your choice: ");
			choice = scan.nextInt();
			
			// run code based on choice
			double amount = 0.0;
			switch(choice)
			{
			case 1:
				// acct1 to acct2
				System.out.print("\nEnter amount: ");
				amount = scan.nextDouble();
				//acct1.transfer(acct2, amount);
				Account.transfer(acct1, acct2, amount);
				System.out.println();
				System.out.println(acct1);
				System.out.println();
				System.out.println(acct2);
				break;
			case 2:
				// acct2 to acct1
				System.out.print("\nEnter amount: ");
				amount = scan.nextDouble();
				//acct2.transfer(acct1, amount);
				Account.transfer(acct2, acct1, amount);
				System.out.println();
				System.out.println(acct1);
				System.out.println();
				System.out.println(acct2);
				break;
			case 3:
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nError.  Please select from the menu.");
			}
		}
		while(choice != 3);
		
		// summary
		System.out.println("\nSummary\n");
		System.out.println(acct1);
		System.out.println();
		System.out.println(acct2);
		
		scan.close();
	}

}
