package oop;

import java.util.Scanner;

public class ScoreProgram {
	public static void main(String[] args) {
		// 메뉴 입력
		int menu;
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		while(true){
			menu = inputMenu();
			
			switch(menu){
			case 1:
				inputExam(kor,eng,math);
				break;
			case 2:
				printExam(kor,eng,math);
				break;
			case 3:	
				break;
			}
		}

	}

	public static void printExam(int kor, int eng, int math) {
		System.out.println("┌───────────────────────────────────────────────┐");
		System.out.println("│                                               │");
		System.out.println("│                      성적출력                                           │");
		System.out.println("│                                               │");
		System.out.println("└───────────────────────────────────────────────┘");

		System.out.printf("국어 성적 : %3d \n", kor);
		System.out.printf("영어 성적 : %3d \n", eng);
		System.out.printf("수학 성적 : %3d \n", math);
		System.out.println("───────────────────────────────────────────");
		
	}

	public static void inputExam(int kor, int eng, int math) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("┌───────────────────────────────────────────────┐");
		System.out.println("│                                               │");
		System.out.println("│                      성적입력                                           │");
		System.out.println("│                                               │");
		System.out.println("└───────────────────────────────────────────────┘");
		
		do{
			System.out.println("국어 성적 :");
			kor = scan1.nextInt();
			if(kor > 100 || kor <0)
				System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
		}while(kor > 100 || kor <0);
						
		do{
			System.out.println("영어 성적 :");
			eng = scan1.nextInt();
			if(eng > 100 || eng <0)
				System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
		}while(eng > 100 || eng <0);

		do{
			System.out.println("수학 성적 :");
			math = scan1.nextInt();
			if(math > 100 || math <0)
				System.out.println("성적 범위를 (1~100)을 벗어났습니다. 다시 입력해주세요.");
		}while(math > 100 || math <0);

		System.out.println("───────────────────────────────────────────");
		
		
	}

	public static int inputMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌───────────────────────────────────────────────┐");
		System.out.println("│                                               │");
		System.out.println("│                      메뉴선택                                           │");
		System.out.println("│                                               │");
		System.out.println("└───────────────────────────────────────────────┘");
		System.out.println("1. 성적 입력 ");
		System.out.println("2. 성적 출력 ");
		System.out.println("3. 시스템 종료 ");
		int menu = scan.nextInt();
		
		return menu;
	}
	
}
