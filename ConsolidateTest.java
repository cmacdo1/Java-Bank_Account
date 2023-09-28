import java.util.Scanner;

public class ConsolidateTest
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter first name: ");
		String name1 = scan.nextLine();
		System.out.print("Enter second name: ");
		String name2 = scan.nextLine();
		System.out.print("Enter third name: ");
		String name3 = scan.nextLine();
		
		// create 3 accounts
		Account acct1 = new Account(100, name1);
		Account acct2 = new Account(100, name2);
		Account acct3 = new Account(100, name3);

		
		// print 3 accounts
		System.out.println();
		System.out.println(acct1);
		System.out.println();
		System.out.println(acct2);
		System.out.println();
		System.out.println(acct3);
		
		System.out.println();
		
		acct1.close();
		Account acct4 = Account.consolidate(acct2, acct3);
		
		System.out.println(acct1);
		System.out.println();
		System.out.println(acct2);
		System.out.println();
		System.out.println(acct3);
		System.out.println();
		System.out.println(acct4);
		
		scan.close();
	}

}
