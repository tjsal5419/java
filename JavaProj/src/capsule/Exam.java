package capsule;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math; // 선언은 함수 안에서만 가능
	
	public void setKor(int kor){
		this.kor = kor;
	}
	
	public void print() { // static x -> 인스턴스 함수
		int kor = this.kor;
		int eng = this.eng;
		int math = this.math;
		
		System.out.println("┌───────────────────────────────────────────────┐");
		System.out.println("│                                			            															   │");
		System.out.println("│                	 									성적출력                                          			 │");
		System.out.println("│                                    														           │");
		System.out.println("└───────────────────────────────────────────────┘");

		System.out.printf("국어 성적 : %3d \n",kor);
		System.out.printf("영어 성적 : %3d \n", eng);
		System.out.printf("수학 성적 : %3d \n", math);
		System.out.println("───────────────────────────────────────────");
		
	}

	public void input() {
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

	public int inputMenu() {
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
