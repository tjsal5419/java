import java.util.Scanner;

public class FindOddEven {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true)
		{
			System.out.println("����������������������������");
			System.out.println("������ ������ �Է��ϼ���.");
			num = scan.nextInt();
			
			if(num%2 ==1)
				System.out.println("Ȧ���Դϴ�.");
			else
				System.out.println("¦���Դϴ�.");
		}

	}

}
