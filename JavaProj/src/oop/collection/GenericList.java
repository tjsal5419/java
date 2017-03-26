package oop.collection;

public class GenericList<선미> {
	private 선미[] objects;
	private int index;
	private int capacity;
	
	public GenericList(){
		objects = (선미[])new Object[3];
		index=0;
		capacity=3;
	}

	public void add(선미 obj) {
		if(index>= capacity){ // 배열 공간 부족
			선미[] temp = (선미[])new Object[capacity+5]; // 임시 배열 temp 생성
			for(int i=0; i < index ;i++)
				temp[i] = objects[i]; // exams 갯수 만큼 temp 배열에 넣음
			
			capacity += 5; // 최대 배열 크기 +5 늘려줌
			objects = temp; //exams가 참조하는 배열을 temp로 변경.
		}
		objects[index] = obj;
		index++;
	}

	public int size() {
		return index;
	}

	public Object get(int i) {
		return objects[i];
	}	
}

