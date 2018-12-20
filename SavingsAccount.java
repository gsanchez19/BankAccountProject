
public class SavingsAccount extends BankAccount {
	
	
	
double intRate;

public final double MIN_BAL;
public final double MIN_BAL_FEE;

	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
	super(n,b);
	intRate = r;
	MIN_BAL = mb;;
	MIN_BAL_FEE = mbf;
	
	}
	
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		balance = 0;
		name = n;
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
		
	}


		
	public void withdraw(double amt)
	{
		if(amt >= 0)
		{
			if(amt <= getBalance())
			{
				
				super.withdraw(amt);
				
				if(getBalance() < MIN_BAL)
				{
					super.withdraw(MIN_BAL_FEE);
					return;
				}
				
			}
			else{
					{throw new IllegalArgumentException("Cannot complete transaction (Amount exceeds current balance).");
					}
				}
		}
		
		else
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Amount must not be negative integer).");
			}
		}
	}
	
	
	// check for class type ( SavingAccount, CheckingAccount) must be implemented
	
	public void transfer(BankAccount other, double amt)
	{
		if(name.equals(other.getName()))
		{
			
			if(amt <= getBalance())
			{	
					withdraw(amt);
					other.deposit(amt);
				
			}
			else
			{
				{throw new IllegalArgumentException("Cannot complete transaction (Amount exceeds current balance).");
				}	
			}
			
		}
		else
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Accounts are not under same name.).");
			}	
		}
	}	
	
	
	public void addInterest()
	{
		
		deposit(getBalance()*intRate);
		
	}
	
	public void endOfMonthUpdate()
	{
		addInterest();
		
	}
}
