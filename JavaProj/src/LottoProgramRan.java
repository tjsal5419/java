import java.util.Random;
import java.util.Scanner;

public class LottoProgramRan {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] nums = new int[6];
		int temp, menu;
		Scanner scan = new Scanner(System.in);

		exit: while (true) { // 선택 메뉴를 위한 while문
			boolean isSame = true;
			System.out.println("─────────────────────────────────");
			System.out.println("1~45 중에 6개의 서로 다른 로또 번호 뽑기");
			System.out.println("─────────────────────────────────");
			System.out.println("1. 시작하기");
			System.out.println("2. 끝내기");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				// 서로 다른 로또 번호 생성
				while (isSame) {
					for (int i = 0; i < 6; i++)
						nums[i] = rand.nextInt(45) + 1; // 1~45 중 난수 6개 생성

					exitFor: for (int j = 1; j < 6; j++) { // 6개의 수 2개씩 비교
						for (int k = 0; k < j; k++) {
							if (nums[j] == nums[k]) { // 같은 경우가 있으면 난수 6개 다시 뽑음
								isSame = true;
								System.out.println("같은 난수가 출력되어 다시 뽑습니다.");
								System.out.println();
								break exitFor;
							} else
								isSame = false; // 같은 경우가 없으면 while문을 벗어남
						}
					}

				}
				// 오름 차순으로 정렬
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5 - i; j++)
						if (nums[j] > nums[j + 1]) {
							temp = nums[j];
							nums[j] = nums[j + 1];
							nums[j + 1] = temp;
						}
				}

				// 결과 출력
				System.out.println("6개의 로또번호는");
				for (int i = 0; i < 6; i++)
					System.out.printf("%-3d", nums[i]);
				System.out.println();
				System.out.println();
				break;

			case 2:
				break exit;

			default:
				System.out.println("1, 2중에서 입력해주세요.");
			}
		}
		scan.close();
	}
}
