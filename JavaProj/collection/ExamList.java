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
		if(index>= capacity){ // 배열 공간 부족
			Exam[] temp = new Exam[capacity+5]; // 임시 배열 temp 생성
			for(int i=0; i < index ;i++)
				temp[i] = exams[i]; // exams 갯수 만큼 temp 배열에 넣음
			
			capacity += 5; // 최대 배열 크기 +5 늘려줌
			exams = temp; //exams가 참조하는 배열을 temp로 변경.
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
