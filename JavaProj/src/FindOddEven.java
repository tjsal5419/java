import java.util.Scanner;

public class FindOddEven {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true)
		{
			System.out.println("──────────────");
			System.out.println("임의의 정수를 입력하세요.");
			num = scan.nextInt();
			
			if(num%2 ==1)
				System.out.println("홀수입니다.");
			else
				System.out.println("짝수입니다.");
		}

	}

}
