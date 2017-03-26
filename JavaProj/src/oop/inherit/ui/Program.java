package oop.inherit.ui;

import oop.inherit.entity.Exam;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("오늘 배운 곳은 여기까지");
		Exam exam = new Exam(); // Dependency , 부품 , 모든 객체는 부품이다. 부품은 도구, 도구는 부품x 
		ExamConsole console = new ExamConsole(exam); // 주입, 조립, injection
		//console.setExam(exam);
		console.input();
		console.print();
		//1. Composition(일체형) Has a inheritance.
		//2. Association(조립형) Has a inheritance.
		//3. Aggregation(집합형) Has a inheritance.
		
	}

}
