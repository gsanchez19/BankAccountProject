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
		
		boolean isPromptedSavings;
		boolean found = false;
		boolean notFound = true;
		
		String userName;
		String allAccs = "";
		String accType;
		
		while(inUse)
		{
			// Main Menu
			System.out.println("What would you like to do?");
			System.out.println("To add an account, type /add. ");
			System.out.println("To make a transaction, type /trans.");
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
						isPromptedSavings = true;
						while(isPromptedSavings)
						{
							System.out.println("Would you like to make a savings account?");
							System.out.println("Type /yes to confirm, type /no to deny.");
							String depositDec = userChoice.nextLine();
							if(depositDec.equals("/yes"))
							{
								System.out.println("Please input the name your account will be under: ");
								String choiceNameChecking = userChoice.nextLine();
								boolean selectingInitialDeposit = true;
								while(selectingInitialDeposit)
								{
									// prompts the user if they would like an initial deposit
									System.out.println("Would you like to make an initial deposit?");
									System.out.println("Type /yes to confirm, type /no to deny: ");
									String choiceInitialSavings = userChoice.nextLine();
									if(choiceInitialSavings.equals("/yes"))
									{
										System.out.println("How much would you like to deposit?");
										String initialDeposit = userChoice.nextLine();
										
										while(!isNumeric(initialDeposit))
										{
											System.out.println("That was not a numeric value. Please enter a numeric value above 0.");
											initialDeposit = userChoice.nextLine();
											
											if(isNumeric(initialDeposit))
											{
												while(Double.parseDouble(initialDeposit) <= 0)
												{
													System.out.println("That value was not above 0. Please enter a numeric value above 0: ");
													initialDeposit = userChoice.nextLine();
													if(!isNumeric(initialDeposit))
													{
														break;
													}
												}
											}
										}
										
										
										
										balance = Double.parseDouble(initialDeposit);
										accounts.add(new SavingsAccount(choiceNameChecking, balance, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
										System.out.println("Account successfully added.");
										selectingInitialDeposit = false;
										isPromptedSavings = false;
										makingAcc = false;
										choiceAcc = "";
										
											
										
										
									}
									
									else if(choiceInitialSavings.equals("/no"))
									{
										accounts.add(new SavingsAccount(choiceNameChecking, 0, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
										System.out.println("Account successfully added.");
										selectingInitialDeposit = false; 
										isPromptedSavings = false;
										makingAcc = false;
										choiceAcc = "";
									}
									
									
								}
								
							}
							else if(depositDec.equals("/no"))
							{
								System.out.println("Savings account creation canceled.");
								makingAcc = false;
								isPromptedSavings = false;
								
							}
							
							
						}
						
						
						
					}
					
					// proceeds to checking account creation
					else if(choiceAcc.equals("/check"))
					{
						boolean isPromptedChecking = true;
						while(isPromptedChecking)
						{
							System.out.println("Would you like to make a checking account?");
							System.out.println("Type /yes to confirm, type /no to deny.");
							String depositDec = userChoice.nextLine();
							if(depositDec.equals("/yes"))
							{
								System.out.println("Please input the name your account will be under: ");
								String choiceNameChecking = userChoice.nextLine();
								boolean selectingInitialDeposit = true;
								
								// prompt user for initial deposit
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
											System.out.println("That was not a numeric value. Please enter an acceptable numeric value above 0: ");
											initialDeposit = userChoice.nextLine();
											if(isNumeric(initialDeposit))
											{
												while(Double.parseDouble(initialDeposit) <= 0)
												{
													System.out.println("That value was not above 0. Please enter a numeric value above 0: ");
													initialDeposit = userChoice.nextLine();
													if(!isNumeric(initialDeposit))
													{
														break;
													}
												}
											}
											
										}
										
								
									
											balance = Double.parseDouble(initialDeposit);
											accounts.add(new CheckingAccount(choiceNameChecking, balance, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
											System.out.println("Account successfully added.");
											selectingInitialDeposit = false; 
											isPromptedChecking = false;
											makingAcc = false;
											choiceAcc = "";
										
										
										
										
									}
									
									else if(choiceInitialSavings.equals("/no"))
									{
										accounts.add(new CheckingAccount(choiceNameChecking, 0, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
										System.out.println("Account successfully added.");
										selectingInitialDeposit = false; 
										isPromptedChecking = false;
										makingAcc = false;
										choiceAcc = "";
										
									}
								}
							}
								
							else if(depositDec.equals("/no"))
							{
								System.out.println("Checking account creation canceled.");
								makingAcc = false;
								isPromptedChecking = false;
								choiceAcc = "";
							}
								
							else
							{
									System.out.println("That wasn't an option.");
							}
							}
							
						}
						
					
					
					// goes back to initial account management
					else if(choiceAcc.equals("/back"))
					{
						makingAcc = false;
						
					}
					
					else
					{
						System.out.println("That wasn't a choice, dummy. Try again.");
					}
					
				}
			}
			
			// proceeds to transaction wizard
			else if(choice.equals("/trans"))
			{
				boolean isPromptingTrans = true;
				while(isPromptingTrans)
					{
					System.out.println("What kind of transaction would you like to make?");
					System.out.println("To make a deposit, type /dep");
					System.out.println("To make a withdrawal, type /with ");
					System.out.println("To transfer money from one account to another, type /transf");
					System.out.println("To exit the transaction wizard, type /back ");
					String transChoice = userChoice.nextLine();
					
					if(transChoice.equals("/dep"))
					{
						String depositAmount;
						boolean choseDeposit = true;
						while(choseDeposit)
						{
							found = false;
							notFound = true;
							System.out.println("Please enter your account number: ");
							System.out.println("If you do not know, type 0");
							String userNumber = userChoice.nextLine();
							//while(!isNumeric(userNumber))
							//{
							//	System.out.println("That is not a valid account number. Please enter a valid account number.");
							//}
							//
							
							try
							{
								
								Integer.parseInt(userNumber);
								
							}
							catch (Exception e)
							{
								while(!isNumeric(userNumber))
								{
									System.out.println("Invalid account number. Please enter a valid account number.");
									userNumber = userChoice.nextLine();
									
								}
							}
							
							int i = 0;
							for(BankAccount account : accounts)
							{
								
								if(account.getAcctNum() == Integer.parseInt(userNumber))
								{
								found = true;
								notFound = false;
									while(found)
									{
										System.out.println("How much would you like to deposit into this account?");
										System.out.println("Type /cancel to cancel this transaction.");
										depositAmount = userChoice.nextLine();
										if(depositAmount.equals("/cancel"))
										{
											choseDeposit = false;
											break;
											
										}
										
										while(!isNumeric(depositAmount))
										{
											System.out.println("That was not a numeric value. Please enter a numeric value above 0.");
											depositAmount = userChoice.nextLine();
											
											if(isNumeric(depositAmount))
											{
												while(Double.parseDouble(depositAmount) < 0)
												{
													System.out.println("That value was not 0 or above. Please enter a numeric value 0 or above: ");
													depositAmount = userChoice.nextLine();
													if(!isNumeric(depositAmount))
													{
														break;
													}
												}
												
												
											}
										}
										
										try {
											account.deposit(Double.parseDouble(depositAmount));
											System.out.println("Transaction authorized successfully!");
											choseDeposit = false;
											break;
										}
										
										catch(IllegalArgumentException e)
										{
											System.out.println("Transaction not authorized.");
											choseDeposit = false;
											break;
										}
										
										
										
										
										
									}
								}
								
							}
							
							
							if(notFound)
							{
								System.out.println("Account not found.");
							}
							while(notFound)
							{
								System.out.println("To view all owned accounts, please type in your name.");
								userName = userChoice.nextLine();
								allAccs = "";
								for(BankAccount account : accounts)
								{
									
									if(account.getName().equals(userName))
									{
										if(account instanceof SavingsAccount)
										{
										System.out.println(account.toString() + " Type: Savings Account.");
										}
										
										if(account instanceof CheckingAccount)
										{
										System.out.println(account.toString() + " Type: Savings Account.");
										}
										allAccs = "1";
									}
								}
								if(allAccs.equals(""))
								{
									System.out.println("No associated accounts found under this name.");
									choseDeposit = false;
									break;
								}
								else
								{
									notFound = false;
								}

							}
							
							found = false;
							notFound = true;
							
						}
						
					}
					
					else if(transChoice.equals("/with"))
					{
						String withdrawAmount;
						boolean choseWithdraw = true;
						while(choseWithdraw)
						{
							found = false;
							notFound = true;
							System.out.println("Please enter your account number: ");
							System.out.println("If you do not know, type 0");
							String userNumber = userChoice.nextLine();
							//while(!isNumeric(userNumber))
							//{
							//	System.out.println("That is not a valid account number. Please enter a valid account number.");
							//}
							//
							
							try
							{
								
								Integer.parseInt(userNumber);
								
							}
							catch (Exception e)
							{
								while(!isNumeric(userNumber))
								{
									System.out.println("Invalid account number. Please enter a valid account number.");
									userNumber = userChoice.nextLine();
									
								}
							}
							
							int i = 0;
							for(BankAccount account : accounts)
							{
								
								if(account.getAcctNum() == Integer.parseInt(userNumber))
								{
								found = true;
								notFound = false;
									while(found)
									{
										System.out.println("How much would you like to withdraw from this account?");
										System.out.println("Type /cancel to cancel this transaction.");
										withdrawAmount = userChoice.nextLine();
										if(withdrawAmount.equals("/cancel"))
										{
											choseWithdraw = false;
											break;
											
										}
										
										while(!isNumeric(withdrawAmount))
										{
											System.out.println("That was not a numeric value. Please enter a numeric value above 0.");
											withdrawAmount = userChoice.nextLine();
											
											if(isNumeric(withdrawAmount))
											{
												while(Double.parseDouble(withdrawAmount) < 0)
												{
													System.out.println("That value was not 0 or above. Please enter a numeric value 0 or above: ");
													withdrawAmount = userChoice.nextLine();
													if(!isNumeric(withdrawAmount))
													{
														break;
													}
												}
												
												
											}
										}
										
										try {
											account.withdraw(Double.parseDouble(withdrawAmount));
											System.out.println("Transaction authorized successfully!");
											choseWithdraw = false;
											break;
										}
										
										catch(IllegalArgumentException e)
										{
											System.out.println("Transaction not authorized.");
											choseWithdraw = false;
											break;
										}
										
										
										
										
										
									}
								}
								
							}
							
							
							if(notFound)
							{
								System.out.println("Account not found.");
							}
							while(notFound)
							{
								System.out.println("To view all owned accounts, please type in your name.");
								userName = userChoice.nextLine();
								allAccs = "";
								for(BankAccount account : accounts)
								{
									
									if(account.getName().equals(userName))
									{
										if(account instanceof SavingsAccount)
										{
										System.out.println(account.toString() + " Type: Savings Account.");
										}
										
										if(account instanceof CheckingAccount)
										{
										System.out.println(account.toString() + " Type: Checking Account.");
										}
										allAccs = "1";
									}
								}
								if(allAccs.equals(""))
								{
									System.out.println("No associated accounts found under this name.");
									choseWithdraw = false;
									break;
								}
								else
								{
									notFound = false;
								}

							}
							
							found = false;
							notFound = true;
							
						}
					}
					
					else if(transChoice.equals("/transf"))
					{
						boolean isPromptingTransfer = true;
						while(isPromptingTransfer)
						{
							System.out.println("Please input the number of the account you will be withdrawing from: ");
							System.out.println("If you do not know, type 0");
							String userWithdrawn = userChoice.nextLine();
							
							try
							{
								
								Integer.parseInt(userWithdrawn);
								
							}
							catch (Exception e)
							{
								while(!isNumeric(userWithdrawn))
								{
									System.out.println("Invalid account number. Please enter a valid account number.");
									userWithdrawn = userChoice.nextLine();
								}
							}
							
							int accWithdrawnConfirmed = 0;
							for(BankAccount account :  accounts)
							{
								if(Integer.parseInt(userWithdrawn) == account.getAcctNum())
								{
									accWithdrawnConfirmed = 1;
									System.out.println("Account user found!");
								}
							}
							
							while(accWithdrawnConfirmed == 0)
							{
								System.out.println("Account not found.");
								System.out.println("To view all owned accounts, please type in your name.");
								userName = userChoice.nextLine();
								allAccs = "";
								for(BankAccount account : accounts)
								{
									
									if(account.getName().equals(userName))
									{
										if(account instanceof SavingsAccount)
										{
										System.out.println(account.toString() + " Type: Savings Account.");
										}
										
										if(account instanceof CheckingAccount)
										{
										System.out.println(account.toString() + " Type: Checking Account.");
										}
										allAccs = "1";
									}
								}
								if(allAccs.equals(""))
								{
									System.out.println("No associated accounts found under this name.");
									isPromptingTransfer = false;
									break;
								}
								else
								{
									break;
								}
							}
							
							while(accWithdrawnConfirmed == 1)
							{
								System.out.println("Please input the number of the account you will be transferring to.");
								System.out.println("If you do not know, type 0");
								String userTransferred = userChoice.nextLine();
								
								try
								{
									
									Integer.parseInt(userTransferred);
									
								}
								catch (Exception e)
								{
									while(!isNumeric(userTransferred))
									{
										System.out.println("Invalid account number. Please enter a valid account number.");
										userTransferred = userChoice.nextLine();
									}
								}
								
								int accTransferredConfirmed = 0;
								for(BankAccount account :  accounts)
								{
									if(Integer.parseInt(userTransferred) == account.getAcctNum())
									{
										accTransferredConfirmed = 1;
										System.out.println("Account found!");
									}
								}
								
								while(accTransferredConfirmed == 0)
								{
									System.out.println("Account user not found.");
									System.out.println("To view all owned accounts, please type in your name.");
									userName = userChoice.nextLine();
									allAccs = "";
									for(BankAccount account : accounts)
									{
										
										if(account.getName().equals(userName))
										{
											if(account instanceof SavingsAccount)
											{
											System.out.println(account.toString() + " Type: Savings Account.");
											}
											
											if(account instanceof CheckingAccount)
											{
											System.out.println(account.toString() + " Type: Checking Account.");
											}
											allAccs = "1";
										}
									}
									if(allAccs.equals(""))
									{
										System.out.println("No associated accounts found under this name.");
										isPromptingTransfer = false;
										break;
									}
									else
									{
										break;
									}
								}
								
								while(accTransferredConfirmed == 1)
								{
									System.out.println("Both accounts are initialized. How much money would you like to transfer?");
									System.out.println("Type /cancel to cancel this transaction.");
									String transferAmount = userChoice.nextLine();
									
									if(transferAmount.equals("/cancel"))
									{
										accWithdrawnConfirmed = 0;
										isPromptingTransfer = false;
										break;
									}
									
									while(!isNumeric(transferAmount))
									{
										System.out.println("That was not a numeric value. Please enter a numeric value above 0.");
										transferAmount = userChoice.nextLine();
										
										if(isNumeric(transferAmount))
										{
											while(Double.parseDouble(transferAmount) < 0)
											{
												System.out.println("That value was not 0 or above. Please enter a numeric value 0 or above: ");
												transferAmount = userChoice.nextLine();
												if(!isNumeric(transferAmount))
												{
													break;
												}
											}
											
											
										}
									}
									
									if(isNumeric(transferAmount))
									{
										boolean authorized = false;
										for(BankAccount account :  accounts)
										{
											if(Integer.parseInt(userWithdrawn) == account.getAcctNum())
											{
												try 
												{
													account.withdraw(Double.parseDouble(transferAmount));
													System.out.println("Withdrawing...");
													authorized = true;
												}
												
												catch(IllegalArgumentException e)
												{
													System.out.println("Transaction not authorized.");
													
													accWithdrawnConfirmed = 0;
													accTransferredConfirmed = 0;
													isPromptingTransfer = false;
													break;
												}
											}
										}
										
										for(BankAccount account :  accounts)
										{
											if(Integer.parseInt(userTransferred) == account.getAcctNum() && authorized)
											{
												
												try 
												{
													account.deposit(Double.parseDouble(transferAmount));
													System.out.println("Transaction authorized successfully!");
													accWithdrawnConfirmed = 0;
													accTransferredConfirmed = 0;
													isPromptingTransfer = false;
													break;
												}
												
												catch(IllegalArgumentException e)
												{
													System.out.println("Transaction not authorized.");
													accWithdrawnConfirmed = 0;
													accTransferredConfirmed = 0;
													isPromptingTransfer = false;
													break;
												}
											}
										}
									}
									
								}
							}
							
							
						}
						
					}
					
					
					else if(transChoice.equals("/back"))
					{
						isPromptingTrans = false;
					}
					
					else
					{
						System.out.println("That was not an option.");
					}
				}
				
			}
			
			// exits the program if the user says so
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
