import java.util.Scanner;

public class reverseOutput {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ ���ڿ��� �Է��Ͻÿ�.\n");
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
		
		System.out.printf("������ ���ڿ� : %s", reverseStr);
		
	}
}
