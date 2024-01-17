package naveenProgramm;

public class DuplicateElement {

	public static void main(String[] args) {
		String arr[] = { "java","C","C++", "Python","Java"};
		for(int i = 0 ;i<arr.length;i++ )
			{
			for(int j=i+1;j<arr.length;j++);
			{
				if (arr[i]==arr[j])
				{
					System.out.println("Found Duplicate Element : "+arr[i]);
					
				}
			}
			
		}

	}

}
