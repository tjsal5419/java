import java.util.Random;
import java.util.Scanner;

public class LottoProgramRan {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] nums = new int[6];
		int temp, menu;
		Scanner scan = new Scanner(System.in);

		exit: while (true) { // ���� �޴��� ���� while��
			boolean isSame = true;
			System.out.println("������������������������������������������������������������������");
			System.out.println("1~45 �߿� 6���� ���� �ٸ� �ζ� ��ȣ �̱�");
			System.out.println("������������������������������������������������������������������");
			System.out.println("1. �����ϱ�");
			System.out.println("2. ������");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				// ���� �ٸ� �ζ� ��ȣ ����
				while (isSame) {
					for (int i = 0; i < 6; i++)
						nums[i] = rand.nextInt(45) + 1; // 1~45 �� ���� 6�� ����

					exitFor: for (int j = 1; j < 6; j++) { // 6���� �� 2���� ��
						for (int k = 0; k < j; k++) {
							if (nums[j] == nums[k]) { // ���� ��찡 ������ ���� 6�� �ٽ� ����
								isSame = true;
								System.out.println("���� ������ ��µǾ� �ٽ� �̽��ϴ�.");
								System.out.println();
								break exitFor;
							} else
								isSame = false; // ���� ��찡 ������ while���� ���
						}
					}

				}
				// ���� �������� ����
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5 - i; j++)
						if (nums[j] > nums[j + 1]) {
							temp = nums[j];
							nums[j] = nums[j + 1];
							nums[j + 1] = temp;
						}
				}

				// ��� ���
				System.out.println("6���� �ζǹ�ȣ��");
				for (int i = 0; i < 6; i++)
					System.out.printf("%-3d", nums[i]);
				System.out.println();
				System.out.println();
				break;

			case 2:
				break exit;

			default:
				System.out.println("1, 2�߿��� �Է����ּ���.");
			}
		}
		scan.close();
	}
}
