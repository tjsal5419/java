package oop.inherit;

public class OmokList {
	private Omok[] omoks;
	private int index;
	private int capacity;
	
	public OmokList(){
		omoks = new Omok[3];
		index=0;
		capacity=3;
	}

	public void add(Omok omok) {
		if(index>= capacity){ // 배열 공간 부족
			Omok[] temp = new Omok[capacity+5]; // 임시 배열 temp 생성
			for(int i=0; i < index ;i++)
				temp[i] = omoks[i]; // exams 갯수 만큼 temp 배열에 넣음
			
			capacity += 5; // 최대 배열 크기 +5 늘려줌
			omoks = temp; //exams가 참조하는 배열을 temp로 변경.
		}
		omoks[index] = omok;
		index++;
	}
}
