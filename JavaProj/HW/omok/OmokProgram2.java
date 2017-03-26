package omok;
import java.util.Scanner;


public class OmokProgram2 { 	 // made by 선미

	public static void main(String[] args) {
		// 오목판그리기\
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		//초기 저장
		
/*		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 && y == 0)
					Board[y][x] = '┌';
				else if (x == 19 && y == 0)
					Board[y][x] = '┐';
				else if (x == 0 && y == 14)
					Board[y][x] = '└';
				else if (x == 19 && y == 14)
					Board[y][x] = '┘';
				else if (y == 0)
					Board[y][x] = '┬';
				else if (y == 14)
					Board[y][x] = '┴';
				else if (x == 19)
					Board[y][x] = '┤';
				else if (x == 0)
					Board[y][x] = '┣';
				else
					Board[y][x] = '┼';

			}
		}*/

		Board board = new Board(); // 초기 보드 선언
		board.makeBoard(); //초기 보드 생성 후 가짜 보드에 넣어줌;.
		
		char dol = 0;
		boolean mode = true;
		String color = null;
		String turn = "0";
		String back_to;
		Omok omok = new Omok();
			
		System.out.println("────────────오목게임────────────");
		System.out.println("by 선미\n");

		// 先돌을 고를 모드 while 문
		while (mode) 
		{
			board.board = board.board;
			for (int y = 0; y < 15; y++) {
				for (int x = 0; x < 20; x++)
					System.out.printf("%c", board.board[y][x]);
				System.out.println();
			}
			
			System.out.println("흑돌(●)을 하시려면 1, 백돌(○)을 하시려면 0을 입력해주세요.");
			turn = scan1.next();

			if (!turn.equals("0") && !turn.equals("1"))
				System.out.println("1과 0 중에 입력해주세요.");
			else
				mode = false;
		}
		
		System.out.println("────────────Start!────────────");
		System.out.println();
		while (true) { // 게임 반복을 위한 while문

			switch (turn) { // switch 문은 break 걸어줘야함 꼭! 흑, 백 결정
				case "0":
					color = "백 돌"; // 0은 백돌, 1은 흑돌
					dol = '○';
					System.out.println();
					break;
				case "1":
					color = "흑 돌";
					dol = '●';
					System.out.println();
					break;

			}

			System.out.println(color + " 의 차례입니다. (x sp y) : ");

			
			omok.inX = scan1.nextInt() - 1;
			omok.inY = scan1.nextInt() - 1;

			// 오목판 내의 라인 입력 확인
			if (omok.inX > 14 || omok.inY > 19)
				System.out.printf("x는 1~15, Y는 1~20 사이의 수를 입력해주세요.\n");
			else if (omok.inX == -1 || omok.inY == -1)
				System.out.printf("0은 입력 불가한 수입니다. 1 이상의 수를 입력해주세요.\n");
			else {
				if (board.board[omok.inX][omok.inY] == '○' ||board.board[omok.inX][omok.inY] == '●')
					System.out.println("이미 오목알이 존재합니다.. 다시 입력해주세요.\n");

				else // 오목 판 범위 내 수가 존재함
				{
					System.out.println("─────────────────────────");

					if (turn.equals("1")) // 흑 기존 값 저장
					{
						omok.backBlackX = omok.inX; // x좌표
						omok.backBlackY = omok.inY; // y좌표
						omok.backBlackDol = board.board[omok.inX][omok.inY]; // 해당 위치의 값
					}
					else // 백 기존 값 저장
					{
						omok.backWhiteX = omok.inX;
						omok.backWhiteY = omok.inY;
						omok.backWhiteDol = board.board[omok.inX][omok.inY];
					}

					board.board[omok.inX][omok.inY] = dol; // 새 위치에 돌을 놓음.

					// 오목표 출력 & 한 수 무르기

					for (int y = 0; y < 15; y++) {
						for (int x = 0; x < 20; x++)
							System.out.printf("%c", board.board[y][x]);
						System.out.println();
					}

					do { // [y/n]이 아닌 경우를 제어하기 위한 do~while문
						System.out.println("한 수 무르시겠습니까? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn.equals("1")) // 흑, 백 기존 값을 저장 후 수를 무른다.
							{
								omok.inX = omok.backBlackX;
								omok.inY = omok.backBlackY;
								board.board[omok.inX][omok.inY] = omok.backWhiteDol;
							} else { // 수를 무르지 않고 다음 턴 진행
								omok.inX = omok.backWhiteX;
								omok.inY = omok.backWhiteY;
								board.board[omok.inX][omok.inY] = omok.backWhiteDol;
								System.out.println(color + "의 한 수를 물렀습니다.");
							}


							for (int y = 0; y < 15; y++) { // 수를 무른 후, 보드를 그린다.
								for (int x = 0; x < 20; x++)
									System.out.printf("%c", board.board[y][x]);
								System.out.println();
							}
							checkWin(); // 승리 검사 함수
							
							break;
						}

						else if (back_to.equals("n")) // 수를 무르지 않고 다음 턴 진행
						{
							if (turn.equals("1")) // 흑->백 교체
								turn = "0";
							else
								turn = "1";
							break;
						} else
							System.out.println("y 또는 n을 입력해주세요.");
					} while (!back_to.equals("y") || !back_to.equals("n"));
				}

			}
		}

	}
	
	public static void checkWin() {
		for(int i=0 ; i++;)
		
	}
	
	}
