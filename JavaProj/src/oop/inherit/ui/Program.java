package oop.inherit.ui;

import oop.inherit.entity.Exam;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("���� ��� ���� �������");
		Exam exam = new Exam(); // Dependency , ��ǰ , ��� ��ü�� ��ǰ�̴�. ��ǰ�� ����, ������ ��ǰx 
		ExamConsole console = new ExamConsole(exam); // ����, ����, injection
		//console.setExam(exam);
		console.input();
		console.print();
		//1. Composition(��ü��) Has a inheritance.
		//2. Association(������) Has a inheritance.
		//3. Aggregation(������) Has a inheritance.
		
	}

}
