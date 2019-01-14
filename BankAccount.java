
public abstract class BankAccount {

	static int nextAccNum;
	String name;
	int acctNum;
	double balance;
	

	public BankAccount(String n)
	{	
		name = n;
		acctNum = nextAccNum;
		acctNum = (int)(Math.random()* 1000);
		balance = 0;
	}
	
	public BankAccount(String n, double b)
	{
		name = n;
		acctNum = nextAccNum;
		acctNum = (int)(Math.random()* 1000);
		balance = b;
	}


	public void deposit(double amt)
	{
		if(amt > 0)
		{
			
			balance+=amt;
		}
		else
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Amount is negative value).");
			}
		}
		
	}

	public void withdraw(double amt)
	{
		
		if(amt > 0)
		{
		balance-=amt;
		}
		else
		{
			{throw new IllegalArgumentException("Cannot complete transaction (Amount is negative value).");
			}
		}
	}

	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();

	// research public and relation to super
	
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}	
	
	

	public String toString()
	{
		return "" + acctNum + "     " + getName() + "     " + "$" + getBalance();
	}

	public int getAcctNum()
	{
		return acctNum;
	}

}
