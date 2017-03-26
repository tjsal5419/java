package oop.array;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String isContinue; 
		int menu;
		Exam[] exams = new Exam[3];
	
		int index = 0;
		int capacity = 3;
		

		while(true){
			menu = Exam.inputMenu();

			switch(menu)
			{
			case 1:
				
				do{
						if(index>= capacity){ // 배열 공간 부족
							Exam[] temp = new Exam[capacity+5]; // 임시 배열 temp 생성
							for(int i=0; i < index ;i++)
								temp[i] = exams[i]; // exams 갯수 만큼 temp 배열에 넣음
							
							capacity += 5; // 최대 배열 크기 +5 늘려줌
							
							exams = temp; //exams가 참조하는 배열을 temp로 변경.
							
						}
						
						exams[index] = new Exam();
						exams[index].input();
						
						index++;
						System.out.println("계속 입력하시겠습니까?[y /n]");
						isContinue = scan.nextLine();
				}while(!isContinue.equals("n"));
					
				break;
					
			case 2:
				for(int i =0 ; i<index ; i++)
					exams[i].print();
				break;
			case 3:	
				break;
			}
		}

	}

	
}
