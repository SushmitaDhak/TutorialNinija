package programm;

public class SwappingTwoNumbers {

	public static void main(String[] args) {
		int a= 10 , b=20 ;
				System.out.println("Before Swapping Values Are "+a +  "  " + b);
				//1 
				/*int t = a ;
				a=b;
				b=t;*/
				//System.out.println("Atfer Swapping Values are "+ a + " "+ b );
				a=a+b;
				b=a-b;
				a=a-b;
				System.out.println("Swapping Number "+a + " "+b );

	}

}
