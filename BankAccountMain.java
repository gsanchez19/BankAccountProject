import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {

	
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		// Constants
		final double OVER_DRAFT_FEE = 15;
		final double RATE = 0.0025;
		final double TRANSACTION_FEE = 1.5;
		final double MIN_BAL = 300;
		final double MIN_BAL_FEE = 10;
		final double FREE_TRANSACTIONS = 10;
		
		boolean inUse = true;
		
		while(inUse)
		{
			System.out.println("What would you like to do?");
			System.out.println("To add an account, type /add. ");
			System.out.println("To make a transaction, type /tran.");
			System.out.println("To exit account management, type /exit.");
			
			Scanner userChoice = new Scanner(System.in);
			
			String choice = userChoice.nextLine();
			
			// Sends to Account Creation
			if(choice.equals("/add"))
			{
				boolean makingAcc = true;
				
				// Account Creation Wizard
				while(makingAcc)
				{
					
					System.out.println("Input what type of account you would like to create.");
					System.out.println("Type '/check' for checking account creation.");
					System.out.println("Type /save for savings account creation.");
					System.out.println("To return to account management, type /back.");
					String choiceAcc = userChoice.nextLine();
					boolean accDecision = true;
					
					// proceeds to savings account creation
					if(choiceAcc.equals("/save"))
					{
						
						
					}
					
					// proceeds to checking account creation
					else if(choiceAcc.equals("/check"))
					{
						while(accDecision = true)
						{
							System.out.println("Would you like to make an initial deposit?");
							System.out.println("Type /yes to confirm, type /no to deny.");
							String depositDec = userChoice.nextLine();
							if(depositDec.equals("/yes"))
							{
								
								
							}
							
							
						}
						
					}
					
					// goes back to initial account management
					else if(choiceAcc.equals("/back"))
					{
						
						
					}
					
					else
					{
						System.out.println("That wasn't a choice, dummy. Try again.");
					}
					
				}
			}
			
			else if(choice.equals("/tran"))
			{
				
			}
			
			else if(choice.equals("/exit"))
			{
				inUse = false;
			}
				
			else
			{
				System.out.println("That wasn't an option.");
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
}
