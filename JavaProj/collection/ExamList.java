package oop.collection;

public class ExamList {
	private Exam[] exams;
	private int index;
	private int capacity;
	
	public ExamList(){
		exams = new Exam[3];
		index=0;
		capacity=3;
	}

	public void add(Exam exam) {
		if(index>= capacity){ // �迭 ���� ����
			Exam[] temp = new Exam[capacity+5]; // �ӽ� �迭 temp ����
			for(int i=0; i < index ;i++)
				temp[i] = exams[i]; // exams ���� ��ŭ temp �迭�� ����
			
			capacity += 5; // �ִ� �迭 ũ�� +5 �÷���
			exams = temp; //exams�� �����ϴ� �迭�� temp�� ����.
		}
		exams[index] = exam;
		index++;
	}

	public int size() {
		return index;
	}

	public Exam get(int i) {
		return exams[i];
	}
	
}
