package omok.omok;

import java.util.Scanner;

public class Turn {
	private String turn; // 턴이 "0"이면 흰 돌, "1"이면 검은 돌
	Turn() {
		turn = "0";
	}
	
	public String getTurn(){
		return turn;
	}
	
	public void selectTurn(Omok omok) {
		Scanner scan = new Scanner(System.in);
		
		while(true) // 先돌을 고를 모드 while 문
		{
			System.out.println("흑돌(●)을 하시려면 1, 백돌(○)을 하시려면 0을 입력해주세요.");
			turn = scan.next();
			
			if (!turn.equals("0") && !turn.equals("1"))
				System.out.println("1과 0 중에 입력해주세요.");
			else
			{
				switch (turn) { // switch 문은 break 걸어줘야함 꼭! 흑, 백 결정
				case "0":
					omok.setDol("○"); // 0은 백돌, 1은 흑돌
					omok.setDolColor("흰 돌");
					break;
				case "1":
					omok.setDol("●");
					omok.setDolColor("흑 돌");
					break;
				}
				
				break;
			}
			
		}
		
	}
	public void changeTurn(Omok omok) {
		
		if (turn.equals("1")) // 흑->백의 턴 교체
		{
			turn = "0";
			omok.setDol("○"); // 0은 백돌, 1은 흑돌
			omok.setDolColor("흰 돌");
		}
		
		else
		{
			turn = "1";
			omok.setDol("●");
			omok.setDolColor("흑 돌");
		}
	}
}
