import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		int kor = 0, eng = 0, math = 0, sci = 0;
		int sum = 0, menu;
		float avg = 0;

		Scanner scan = new Scanner(System.in);

		Exit: while (true) {
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("��                                               ��");
			System.out.println("��                      �޴�����                                           ��");
			System.out.println("��                                               ��");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("1. ���� �Է� ");
			System.out.println("2. ���� ��� ");
			System.out.println("3. �ý��� ���� ");

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.println("��������������������������������������������������������������������������������������������������");
				System.out.println("��                                               ��");
				System.out.println("��                      �����Է�                                           ��");
				System.out.println("��                                               ��");
				System.out.println("��������������������������������������������������������������������������������������������������");
				
				do{
					System.out.println("���� ���� :");
					kor = scan.nextInt();
					if(kor > 100 || kor <0)
						System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
				}while(kor > 100 || kor <0);
								
				do{
					System.out.println("���� ���� :");
					eng = scan.nextInt();
					if(eng > 100 || eng <0)
						System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
				}while(eng > 100 || eng <0);

				do{
					System.out.println("���� ���� :");
					math = scan.nextInt();
					if(math > 100 || math <0)
						System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
				}while(math > 100 || math <0);
				
				do{
					System.out.println("���� ���� :");
					sci = scan.nextInt();
					if(sci > 100 || sci <0)
						System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
				}while(sci > 100 || sci <0);
				

				sum = eng + kor + sci + math;
				avg = sum / 4.0f;
				System.out.println("��������������������������������������������������������������������������������������");
				break;

			case 2:

				System.out.println("��������������������������������������������������������������������������������������������������");
				System.out.println("��                                               ��");
				System.out.println("��                      �������                                           ��");
				System.out.println("��                                               ��");
				System.out.println("��������������������������������������������������������������������������������������������������");
				for (int i = 0; i < 3; i++) {
					System.out.printf("���� ���� : %3d \n", kor);
					System.out.printf("���� ���� : %3d \n", eng);
					System.out.printf("���� ���� : %3d \n", math);
					System.out.printf("���� ���� : %3d \n", sci);
					System.out.printf("���� : %3d \n", sum);
					System.out.printf("��� : %.2f \n", avg);
					System.out.println("��������������������������������������������������������������������������������������");
				}
				break;

			case 3:
				break Exit;

			default: // default�� ����ġ ���� ����� ���� �뵵�� break �ʿ� ����.
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}

	}
}