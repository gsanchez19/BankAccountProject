import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {

	
	private static boolean isNumeric(String str)
	{
	try
	{
	Double.parseDouble(str);
	return true;
	}
	catch(IllegalArgumentException e)
	{
		return false;
	}
	}
	
	
		
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		// Constants
		final double OVER_DRAFT_FEE = 15;
		final double RATE = 0.0025;
		final double TRANSACTION_FEE = 1.5;
		final double MIN_BAL = 300;
		final double MIN_BAL_FEE = 10;
		final int FREE_TRANSACTIONS = 10;
		
		double balance;
		boolean inUse = true;
		
		while(inUse)
		{
			// Main Menu
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
							System.out.println("Would you like to make a checking account?");
							System.out.println("Type /yes to confirm, type /no to deny.");
							String depositDec = userChoice.nextLine();
							if(depositDec.equals("/yes"))
							{
								System.out.println("Please input the name your account will be under: ");
								String choiceNameChecking = userChoice.nextLine();
								boolean selectingInitialDeposit = true;
								while(selectingInitialDeposit)
								{
									System.out.println("Would you like to make an initial deposit?");
									System.out.println("Type /yes to confirm, type /no to deny: ");
									String choiceInitialSavings = userChoice.nextLine();
									if(choiceInitialSavings.equals("/yes"))
									{
										System.out.println("How much would you like to deposit?");
										String initialDeposit = userChoice.nextLine();
										
										while(!isNumeric(initialDeposit))
										{
											System.out.println("That was not a numeric value. Please enter a numeric value.");
											initialDeposit = userChoice.nextLine();
										}
										
										balance = Double.parseDouble(initialDeposit);
										accounts.add(new CheckingAccount(choiceNameChecking, balance, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
										System.out.println("Account successfully added.");
										
											
										
										
									}
									
									else if(choiceInitialSavings.equals("/no"))
									{
										accounts.add(new CheckingAccount(choiceNameChecking, 0, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
										System.out.println("Account successfully added.");
									}
									
									
								}
								
							}
							else if(depositDec.equals("/no"))
							{
								System.out.println("Checking account creation canceled.");
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
			
			// proceeds to transaction wizard
			else if(choice.equals("/tran"))
			{
				
			}
			
			// exits the program if the user is a wuss
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
