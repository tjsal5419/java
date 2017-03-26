package oop.inherit.ui;

import java.util.Scanner;
import oop.inherit.entity.Exam;

public class ExamConsole {
	private Exam exam; // has a ���

/*	
	public void setExam(Exam exam) {
		this.exam = exam;
	}
*/
	public ExamConsole(Exam exam) {
		this.exam = exam;
		
	}
	
	public void print() { // static x -> �ν��Ͻ� �Լ�
		
		int kor = exam.getKor();
		int eng = exam.getEng();
		int math = exam.getMath();

		int total = exam.total();
		float avg = exam.avg();
		
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                			            															   ��");
		System.out.println("��                	 									�������                                          			 ��");
		System.out.println("��                                    														           ��");
		System.out.println("��������������������������������������������������������������������������������������������������");

		System.out.printf("���� ���� : %3d \n",kor);
		System.out.printf("���� ���� : %3d \n", eng);
		System.out.printf("���� ���� : %3d \n", math);
		System.out.printf("�� �� : %3d \n",total);
		System.out.printf("�� �� : %f.2 \n", avg);
		System.out.println("��������������������������������������������������������������������������������������");
		
	}

	public void input() {
		Scanner scan1 = new Scanner(System.in);

		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                               ��");
		System.out.println("��                      �����Է�                                           ��");
		System.out.println("��                                               ��");
		System.out.println("��������������������������������������������������������������������������������������������������");
		int kor,eng,math;
		
		
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

		
		System.out.println("��������������������������������������������������������������������������������������");
		
		exam.setEng(eng);
		exam.setKor(kor);
		exam.setMath(math);
		
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
