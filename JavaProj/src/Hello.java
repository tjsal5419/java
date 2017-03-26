import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		int kor = 0, eng = 0, math = 0, sci = 0;
		int sum = 0, menu;
		float avg = 0;

		Scanner scan = new Scanner(System.in);

		Exit: while (true) {
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│                                               │");
			System.out.println("│                      메뉴선택                                           │");
			System.out.println("│                                               │");
			System.out.println("└───────────────────────────────────────────────┘");
			System.out.println("1. 성적 입력 ");
			System.out.println("2. 성적 출력 ");
			System.out.println("3. 시스템 종료 ");

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.println("┌───────────────────────────────────────────────┐");
				System.out.println("│                                               │");
				System.out.println("│                      성적입력                                           │");
				System.out.println("│                                               │");
				System.out.println("└───────────────────────────────────────────────┘");
				
				do{
					System.out.println("국어 성적 :");
					kor = scan.nextInt();
					if(kor > 100 || kor <0)
						System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
				}while(kor > 100 || kor <0);
								
				do{
					System.out.println("영어 성적 :");
					eng = scan.nextInt();
					if(eng > 100 || eng <0)
						System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
				}while(eng > 100 || eng <0);

				do{
					System.out.println("수학 성적 :");
					math = scan.nextInt();
					if(math > 100 || math <0)
						System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
				}while(math > 100 || math <0);
				
				do{
					System.out.println("과학 성적 :");
					sci = scan.nextInt();
					if(sci > 100 || sci <0)
						System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
				}while(sci > 100 || sci <0);
				

				sum = eng + kor + sci + math;
				avg = sum / 4.0f;
				System.out.println("───────────────────────────────────────────");
				break;

			case 2:

				System.out.println("┌───────────────────────────────────────────────┐");
				System.out.println("│                                               │");
				System.out.println("│                      성적출력                                           │");
				System.out.println("│                                               │");
				System.out.println("└───────────────────────────────────────────────┘");
				for (int i = 0; i < 3; i++) {
					System.out.printf("국어 성적 : %3d \n", kor);
					System.out.printf("영어 성적 : %3d \n", eng);
					System.out.printf("수학 성적 : %3d \n", math);
					System.out.printf("과학 성적 : %3d \n", sci);
					System.out.printf("총점 : %3d \n", sum);
					System.out.printf("평균 : %.2f \n", avg);
					System.out.println("───────────────────────────────────────────");
				}
				break;

			case 3:
				break Exit;

			default: // default는 스위치 문을 벗어나기 위한 용도로 break 필요 없음.
				System.out.println("1부터 3까지의 숫자를 입력해주세요.");
			}
		}

	}
}