package reuse;

import java.util.Scanner;

public class ExamLib {

	public static void print(Exam exam) {
		int kor = exam.kor;
		int eng = exam.eng;
		int math = exam.math;
		
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                               ��");
		System.out.println("��                      �������                                           ��");
		System.out.println("��                                               ��");
		System.out.println("��������������������������������������������������������������������������������������������������");

		System.out.printf("���� ���� : %3d \n",kor);
		System.out.printf("���� ���� : %3d \n", eng);
		System.out.printf("���� ���� : %3d \n", math);
		System.out.println("��������������������������������������������������������������������������������������");
		
	}

	public static void input(Exam exam) {
		Scanner scan1 = new Scanner(System.in);
		int math, kor, eng;
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                               ��");
		System.out.println("��                      �����Է�                                           ��");
		System.out.println("��                                               ��");
		System.out.println("��������������������������������������������������������������������������������������������������");
		
		do{
			System.out.println("���� ���� :");
			kor = scan1.nextInt();
			if(kor > 100 || kor <0)
				System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
		}while(kor > 100 || kor <0);
						
		do{
			System.out.println("���� ���� :");
			eng = scan1.nextInt();
			if(eng > 100 || eng <0)
				System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
		}while(eng > 100 || eng <0);

		do{
			System.out.println("���� ���� :");
			math = scan1.nextInt();
			if(math > 100 || math <0)
				System.out.println("���� ������ (1~100)�� ������ϴ�. �ٽ� �Է����ּ���.");
		}while(math > 100 || math <0);

		exam.eng = eng;
		exam.kor = kor;
		exam.math = math;
		
		System.out.println("��������������������������������������������������������������������������������������");

	}

	public static int inputMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                               ��");
		System.out.println("��                      �޴�����                                           ��");
		System.out.println("��                                               ��");
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("1. ���� �Է� ");
		System.out.println("2. ���� ��� ");
		System.out.println("3. �ý��� ���� ");
		int menu = scan.nextInt();
		
		return menu;
	}
	
}
