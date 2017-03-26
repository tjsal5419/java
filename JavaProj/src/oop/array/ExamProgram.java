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
						if(index>= capacity){ // �迭 ���� ����
							Exam[] temp = new Exam[capacity+5]; // �ӽ� �迭 temp ����
							for(int i=0; i < index ;i++)
								temp[i] = exams[i]; // exams ���� ��ŭ temp �迭�� ����
							
							capacity += 5; // �ִ� �迭 ũ�� +5 �÷���
							
							exams = temp; //exams�� �����ϴ� �迭�� temp�� ����.
							
						}
						
						exams[index] = new Exam();
						exams[index].input();
						
						index++;
						System.out.println("��� �Է��Ͻðڽ��ϱ�?[y /n]");
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
