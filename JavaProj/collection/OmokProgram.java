package oop.collection;

public class OmokProgram {

	public static void main(String[] args) {
		// ��ü�� �غ��ϱ�
		Board board = new Board();
		Omok omok = new Omok();
		OmokList list = new OmokList();
		
		board.print();
		
		omok.input();
		
		board.put(omok);
		
		board.print();
		
	}

}
