package oop.collection;

public class GenericList<����> {
	private ����[] objects;
	private int index;
	private int capacity;
	
	public GenericList(){
		objects = (����[])new Object[3];
		index=0;
		capacity=3;
	}

	public void add(���� obj) {
		if(index>= capacity){ // �迭 ���� ����
			����[] temp = (����[])new Object[capacity+5]; // �ӽ� �迭 temp ����
			for(int i=0; i < index ;i++)
				temp[i] = objects[i]; // exams ���� ��ŭ temp �迭�� ����
			
			capacity += 5; // �ִ� �迭 ũ�� +5 �÷���
			objects = temp; //exams�� �����ϴ� �迭�� temp�� ����.
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

