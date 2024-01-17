package programm;

public class PrimeNumber {

	public static void main(String[] args) {
		int no =7;
		int temp=0;
		for (int i =2 ; i<=no-1;i++)
{
	if (no%i==0)
	{temp=temp+1;
}
}
   if(temp==0)
	{
		System.out.print(no + " Num is not prime");
	}
   else {
	   System.out.print(no + " Num is  prime");
   }
	}

	}

