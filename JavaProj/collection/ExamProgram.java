package oop.collection;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String isContinue; 
		int menu;
	
		ExamList list = new ExamList();
	
		while(true){
			menu = Exam.inputMenu();

			switch(menu)
			{
			case 1:
				
				do{
						Exam exam = new Exam();
						exam.input();
						
						list.add(exam);
					
						System.out.println("계속 입력하시겠습니까?[y /n]");
						isContinue = scan.nextLine();
				}while(!isContinue.equals("n"));
					
				break;
					
			case 2:
				for(int i =0 ; i<list.size() ; i++){
					Exam exam = list.get(i);
					exam.print();
				}
				break;
			case 3:	
				break;
			}
		}

	}

	
}
