import java.util.Scanner;

public class reverseOutput {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("뒤집을 문자열을 입력하시오.\n");
		String input = scan.nextLine();
		scan.close();
		
		char[] arr = new char[input.length()];
		arr = input.toCharArray();
		char temp=0;
		int len = input.length();
		
		for(int i=0;i < len/2 ; i++)
		{
				temp = arr[i];
				arr[i] = arr[(len-1)-i];
				arr[(len-1)-i] = temp;
		}
		
		String reverseStr = "" ;
		
		for(int i=0 ; i <arr.length ; i++)
			reverseStr = reverseStr + arr[i];
		
		System.out.printf("뒤집힌 문자열 : %s", reverseStr);
		
	}
}
