package omok;
import java.util.Scanner;

public class OmokProgram { 	 // made by 선미

	public static void main(String[] args) {
		// 오목판그리기\
		String[][] board = new String[16][21];
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		for (int y = 0; y < 16; y++) {
			for (int x = 0; x < 21; x++){
				if(y ==15 && x<10)
					board[y][x]="/"+String.valueOf(x+1);
				else if(y==15 && x!=20)
					board[y][x]="/"+String.valueOf(x-9);	
				else if(x==20 && y!=15) 
					board[y][x]=String.valueOf(y+1);
				else if(y==15 && x==20)
					board[y][x]=" ";	
				else if (x == 0 && y == 0)
					board[y][x] = "┌";
				else if (x == 19 && y == 0)
					board[y][x] = "┐";
				else if (x == 0 && y == 14)
					board[y][x] = "└";
				else if (x == 19 && y == 14)
					board[y][x] = "┘";
				else if (y == 0)
					board[y][x] = "┬";
				else if (y == 14)
					board[y][x] = "┴";
				else if (x == 19)
					board[y][x] = "┤";
				else if (x == 0)
					board[y][x] = "┣";
				else
					board[y][x] = "┼";

			}
		}
		

		for (int y = 0; y < 16; y++) {
			for (int x = 0; x < 21; x++)
				System.out.printf("%s", board[y][x]);
			System.out.println();
		}
		System.out.println("");
		System.out.println("가로는 행, 세로는 열로 (x,y)로 입력해주세요.");
		
		String dol = "0";
		boolean mode = true;
		String dolColor = null;
		int inX, inY;
		String turn = "0";
		String back_to;
		int back_white_x = 0, back_white_y = 0, back_black_x = 0, back_black_y = 0;
		String back_white=null, back_black = null;

		System.out.println("────────────오목게임────────────");
		System.out.println("by 선미\n");

		while (mode) // 先돌을 고를 모드 while 문
		{
			System.out.println("흑돌을 하시려면 1, 백돌을 하시려면 0을 입력해주세요.");
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
				dolColor = "백 돌"; // 0은 백돌, 1은 흑돌
				dol = "○";
				System.out.println();
				break;
			case "1":
				dolColor = "흑 돌";
				dol = "●";
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
				if (board[inX][inY].equals("○") || board[inX][inY].equals("●"))
					System.out.println("이미 오목알이 존재합니다.. 다시 입력해주세요.\n");

				else // 오목 판 범위 내 수가 존재함
				{
					System.out.println("─────────────────────────");

					if (turn.equals("1")) // 흑 기존 값 저장
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

					for (int y = 0; y < 16; y++) {
						for (int x = 0; x < 21; x++)
							System.out.printf("%s", board[y][x]);
						System.out.println();
					}

					do { // [y/n]이 아닌 경우를 제어하기 위한 do~while문
						System.out.println("한 수 무르시겠습니까? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn.equals("1")) // 흑, 백 기존 값을 저장 후 수를 무른다.
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

							for (int y = 0; y < 16; y++) {
								for (int x = 0; x < 21; x++)
									System.out.printf("%s", board[y][x]);
								System.out.println();
							}
							break;
						}

						else if (back_to.endsWith("n")) // 수를 무르지 않고 다음 턴 진행
						{
							if(checkWin(board, inX, inY)){
								System.out.println("───────────────────────");
								System.out.printf("*****************%s의 승리입니다.*****************\n", dolColor);
								System.out.println("───────────────────────");
								// 게임을 새로 진행할지 묻는 쿼리 추가해야함!!
								System.out.println("게임을 계속 진행하시겠습니까?");
								break;
							}
							
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

// 승리를 판별하는 함수
public static boolean checkWin(String[][] board, int inX, int inY) {
		boolean win = false;
	
		if(inY>=4 && inY<(20-4))
		{
			if(inX<4){
				win = (left(board,inX,inY) || right(board,inX,inY) || leftDown(board, inX, inY) || down(board, inX, inY) ||
						right(board, inX, inY)) ;
			}
			else if(inX>=4 && inX<(15-4)){
				win = (left(board,inX,inY) || right(board,inX,inY) || leftDown(board, inX, inY) || rightDown(board, inX, inY) ||
						up(board,inX,inY) || down(board,inX,inY) || leftUp(board,inX,inY) || rightUp(board,inX,inY) ) ;
			}
			else{
				win = (left(board,inX,inY) || right(board,inX,inY) || up(board,inX,inY) || 
						leftUp(board,inX,inY) || rightUp(board,inX,inY) ) ;
			}
		}
		
		else if(inY<4)
		{
			if(inX<4)
				win = ( right(board,inX,inY) ||  rightDown(board, inX, inY) || down(board,inX,inY) ) ;	
				
			else if(inX>=4 && inX<(15-4))
				win = ( right(board,inX,inY) ||  rightDown(board, inX, inY) ||
						up(board,inX,inY) || down(board,inX,inY) || rightUp(board,inX,inY) ) ;
			else 
				win = ( right(board,inX,inY) || up(board,inX,inY) || rightUp(board,inX,inY) ) ;	
		}
		
		else 
		{
			if(inX<4)
				win = ( left(board,inX,inY) ||  leftDown(board, inX, inY) || down(board,inX,inY) ) ;	

			else if(inX>=4 && inX<(15-4))
				win = (left(board,inX,inY) || leftDown(board, inX, inY) || 
						up(board,inX,inY) || down(board,inX,inY) || leftUp(board,inX,inY) ) ;
			else
				win = (left(board,inX,inY) || leftUp(board, inX, inY) || 
						up(board,inX,inY) ) ;				
		}

	return win ;
}


// 승리 검사를 위한 함수..
public static boolean left(String[][] board, int inX, int inY){
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

public static boolean right(String[][] board, int inX, int inY){
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

public static boolean up(String[][] board, int inX, int inY){
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

public static boolean down(String[][] board, int inX, int inY){
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

public static boolean leftUp(String[][] board, int inX, int inY){
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

public static boolean leftDown(String[][] board, int inX, int inY){
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

public static boolean rightUp(String[][] board, int inX, int inY){
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

public static boolean rightDown(String[][] board, int inX, int inY){
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
