import java.util.Scanner;

public class OmokProgram2 { 	 // made by 선미

	public static void main(String[] args) {
		// 오목판그리기\
		char[][] board = new char[15][20];
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 && y == 0)
					board[y][x] = '┌';
				else if (x == 19 && y == 0)
					board[y][x] = '┐';
				else if (x == 0 && y == 14)
					board[y][x] = '└';
				else if (x == 19 && y == 14)
					board[y][x] = '┘';
				else if (y == 0)
					board[y][x] = '┬';
				else if (y == 14)
					board[y][x] = '┴';
				else if (x == 19)
					board[y][x] = '┤';
				else if (x == 0)
					board[y][x] = '┣';
				else
					board[y][x] = '┼';

			}
		}

		char dol = 0;
		boolean mode = true;
		String dolColor = null;
		int inX, inY;
		int turn = 0;
		String back_to;
		int back_white_x = 0, back_white_y = 0, back_black_x = 0, back_black_y = 0;
		char back_white = 0, back_black = 0;

		System.out.println("────────────오목게임────────────");
		System.out.println("by 선미\n");

		while (mode) // 先돌을 고를 모드 while 문
		{
			System.out.println("흑돌을 하시려면 1, 백돌을 하시려면 0을 입력해주세요.");
			turn = scan1.nextInt();

			if (turn != 1 && turn != 0)
				System.out.println("1과 0 중에 입력해주세요.");
			else
				mode = false;
		}
		System.out.println("────────────Start!────────────");
		System.out.println();
		while (true) { // 게임 반복을 위한 while문

			switch (turn) { // switch 문은 break 걸어줘야함 꼭! 흑, 백 결정
			case 0:
				dolColor = "백 돌"; // 0은 백돌, 1은 흑돌
				dol = '○';
				System.out.println();
				break;
			case 1:
				dolColor = "흑 돌";
				dol = '●';
				System.out.println();
				break;

			}

			System.out.println(dolColor + " 의 차례입니다. (x sp y) : ");

			inX = scan1.nextInt() - 1;
			inY = scan1.nextInt() - 1;

			if (inX > 14 || inY > 19)
				System.out.printf("x는 1~15, Y는 1~20 사이의 수를 입력해주세요.\n");
			else if (inX == -1 || inY == -1)
				System.out.printf("0은 입력 불가한 수입니다. 1 이상의 수를 입력해주세요.\n");
			else {
				if (board[inX][inY] == '○' || board[inX][inY] == '●')
					System.out.println("이미 오목알이 존재합니다.. 다시 입력해주세요.\n");

				else // 오목 판 범위 내 수가 존재함
				{
					System.out.println("─────────────────────────");

					if (turn == 1) // 흑 기존 값 저장
					{
						back_black_x = inX; // x좌표
						back_black_y = inY; // y좌표
						back_black = board[inX][inY]; // 해당 위치의 값
					}
					else // 백 기존 값 저장
					{
						back_white_x = inX;
						back_white_y = inY;
						back_white = board[inX][inY];
					}

					board[inX][inY] = dol; // 새 위치에 돌을 놓음.

					// 오목표 출력 & 한 수 무르기

					for (int y = 0; y < 15; y++) {
						for (int x = 0; x < 20; x++)
							System.out.printf("%c", board[y][x]);
						System.out.println();
					}

					do { // [y/n]이 아닌 경우를 제어하기 위한 do~while문
						System.out.println("한 수 무르시겠습니까? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn == 1) // 흑, 백 기존 값을 저장 후 수를 무른다.
							{
								inX = back_black_x;
								inY = back_black_y;
								board[inX][inY] = back_black;
							} else {
								inX = back_white_x;
								inY = back_white_y;
								board[inX][inY] = back_white;
							}

							System.out.println(dolColor + "의 한 수를 물렀습니다.");

							for (int y = 0; y < 15; y++) {
								for (int x = 0; x < 20; x++)
									System.out.printf("%c", board[y][x]);
								System.out.println();
							}
							break;
						}

						else if (back_to.endsWith("n")) // 수를 무르지 않고 다음 턴 진행
						{
							if(checkWin(board, inX, inY)){
								System.out.println(dolColor + "가 이겼다");
								break;
							}
							
							if (turn == 1) // 흑->백 교체
								turn = 0;
							else
								turn = 1;
							break;
						} else
							System.out.println("y 또는 n을 입력해주세요.");
						
					} while (!back_to.equals("y") || !back_to.equals("n"));
				}

			}
		}

	}

public static boolean checkWin(char[][] board, int inX, int inY) {
		boolean win = false;
		System.out.println("승리를 검사하는 함수입니다.");
		
		if(inY>=4 && inY<(20-4)){
			if(inX<4){
				win = (left(board,inX,inY) || right(board,inX,inY) || leftDown(board, inX, inY) || down(board, inX, inY) ||
						right(board, inX, inY)) ;
			}
			else if(inX>=4 && inX<(15-4)){
				win = (left(board,inX,inY) || right(board,inX,inY) || leftDown(board, inX, inY) || rightDown(board, inX, inY) ||
						up(board,inX,inY) || down(board,inX,inY) || leftUp(board,inX,inY) || rightUp(board,inX,inY) ) ;
			}
			else if(inX>=(15-4)){
				win = (left(board,inX,inY) || right(board,inX,inY) || up(board,inX,inY) || 
						leftUp(board,inX,inY) || rightUp(board,inX,inY) ) ;
			}
		}
		else if(inY<4){
			if(inX>=4 && inX<(15-4))
				win = ( right(board,inX,inY) ||  rightDown(board, inX, inY) ||
						up(board,inX,inY) || down(board,inX,inY) || rightUp(board,inX,inY) ) ;		
		}
		else {
			if(inX>=4 && inX<=(15-4))
				win = (left(board,inX,inY) || leftDown(board, inX, inY) || 
						up(board,inX,inY) || down(board,inX,inY) || leftUp(board,inX,inY) ) ;
		}

	return win ;
}

public static boolean left(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX][inY-i]) 
			count++;
	}
	
	if(count==4)
		return true;
	else 
		return false;

}

public static boolean right(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX][inY+i]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

	
}

public static boolean up(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX-i][inY]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

}

public static boolean down(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX+i][inY]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

	
}

public static boolean leftUp(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX-i][inY-i]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

}

public static boolean leftDown(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX+i][inY-i]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

	
}

public static boolean rightUp(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX-i][inY+i]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

	
}

public static boolean rightDown(char[][] board, int inX, int inY){
	int count =0;
	for(int i=1; i<=4; i++)
	{
		if(board[inX][inY]==board[inX+i][inY+i]) 
			count++;
	}
	if(count==4)
		return true;
	else 
		return false;

	
}
}
