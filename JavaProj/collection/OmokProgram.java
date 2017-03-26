package oop.collection;

public class OmokProgram {

	public static void main(String[] args) {
		// 객체들 준비하기
		Board board = new Board();
		Omok omok = new Omok();
		OmokList list = new OmokList();
		
		board.print();
		
		omok.input();
		
		board.put(omok);
		
		board.print();
		
	}

}
