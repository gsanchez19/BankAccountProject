import java.util.Scanner;
public class Test {

	private int field1, field2, field3;
	private String str;
	public Test (int field, int field2, int field3, String str)
	{
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public Test(int field2, int field3, String str)
	{
		this(0, field2, field3, str);
	}
	
	public Test(int field3, String str)
	{
		this(0,1,field3,str);
	}
	
	
	
	
	
	
}
