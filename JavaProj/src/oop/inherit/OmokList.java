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
		if(index>= capacity){ // �迭 ���� ����
			Omok[] temp = new Omok[capacity+5]; // �ӽ� �迭 temp ����
			for(int i=0; i < index ;i++)
				temp[i] = omoks[i]; // exams ���� ��ŭ temp �迭�� ����
			
			capacity += 5; // �ִ� �迭 ũ�� +5 �÷���
			omoks = temp; //exams�� �����ϴ� �迭�� temp�� ����.
		}
		omoks[index] = omok;
		index++;
	}
}
