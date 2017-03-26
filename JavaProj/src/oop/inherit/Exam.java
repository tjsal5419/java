package oop.inherit;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math; // ������ �Լ� �ȿ����� ����
	
	public void setKor(int kor){
		this.kor = kor;
	}
	
	public void print() { // static x -> �ν��Ͻ� �Լ�
		int kor = this.kor;
		int eng = this.eng;
		int math = this.math;
		
		System.out.println("��������������������������������������������������������������������������������������������������");
		System.out.println("��                                			            															   ��");
		System.out.println("��                	 									�������                                          			 ��");
		System.out.println("��                                    														           ��");
		System.out.println("��������������������������������������������������������������������������������������������������");

		System.out.printf("���� ���� : %3d \n",kor);
		System.out.printf("���� ���� : %3d \n", eng);
		System.out.printf("���� ���� : %3d \n", math);
		System.out.println("��������������������������������������������������������������������������������������");
		
	}

	public void input() {
		Scanner scan1 = new Scanner(System.in);

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