// LEARN HOW TO THROW AND CATCH YA WEE 

public class CheckingAccount extends BankAccount {

	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	
	int numTransactions = 0;
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		
		
	}
	
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		balance = 0;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		
		
	}
	
	public void deposit(double amt)
	{
		
		if(amt > 0)
		{
			numTransactions++;
			super.deposit(amt);
			if(numTransactions > FREE_TRANS)
			{
				super.withdraw(TRANSACTION_FEE);
			}
		}
		else
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Amount must be greater than zero).");
			}
		}
		
	}

	public void withdraw(double amt)
	{
		if(amt > -1)
		{
			
			super.withdraw(amt);
			if(amt > getBalance())
			{
				super.withdraw(OVER_DRAFT_FEE);
			}
			
			
			if(numTransactions >= FREE_TRANS)
				{
				super.withdraw(TRANSACTION_FEE);
				
				}
				
			
			numTransactions++;
		}
		
		else{
		{throw new IllegalArgumentException("Amount must be greater than a negative value.");
		}
		}
	
}
	public void transfer(BankAccount other, double amt)
	{
		if (getBalance()-amt >= 0)
		{
			if(super.getName().equals(other.getName()))
			{
				numTransactions++;
				withdraw(amt);
				other.deposit(amt);
			}
			else
			{
				{throw new IllegalArgumentException(" Cannot complete transaction (Names do not match.");
				}
			}
		
		
		}
		
		
		else 
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Amount exceeds current balance).");
			}
		}
	}	
	
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	
	
	
	
	
	
	
	
}
