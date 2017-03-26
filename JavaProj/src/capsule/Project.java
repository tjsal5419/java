package capsule;

import java.util.Scanner;

public class Project {
	public static void main(String[] args) {
		Exam exam = new Exam();
		int menu = exam.inputMenu();
		exam.print();
		exam.setKor(20);
		exam.input();
		

		
	}
	
}
