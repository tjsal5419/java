package omok.omok;

import java.util.Scanner;

public class Board {
	private String[][] board;
	private int m,n;
	private String isBack = null; // "y"면 계속, "n"이면 한 수 무르기
	private int backX, backY;
	private String backDol=null;
	Scanner scan;
	
	public Board(int m, int n) {
		this.m = m;
		this.n = n;
		
		board = new String[m][n];
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++){	
				if(y == (m-1))
				{
					int i = (x+1) % 10;	
					if(x==(n-1))
							board[y][x] = "/♥";
					else if(i == 0)
						board[y][x] = "/10";
					else 
						board[y][x] = "/"+String.valueOf(i);					
				}
						
				else if(x==(n-1) && y!=(m-1)) 
					board[y][x]=String.valueOf(y+1);
				else if(y==(m-1) && x==(n-1))
					board[y][x]=" ";	
				else if (x == 0 && y == 0)
					board[y][x] = "┌";
				else if (x == (n-2) && y == 0)
					board[y][x] = "┐";
				else if (x == 0 && y == (m-2))
					board[y][x] = "└";
				else if (x == (n-2) && y == (m-2))
					board[y][x] = "┘";
				else if (y == 0)
					board[y][x] = "┬";
				else if (y == (m-2))
					board[y][x] = "┴";
				else if (x == (n-2))
					board[y][x] = "┤";
				else if (x == 0)
					board[y][x] = "┣";
				else
					board[y][x] = "┼";

			}
		}
		
    }


	public void drawBoard() 
	{
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++)
				System.out.printf("%s", board[y][x]);
			System.out.println();
		}
	}
	
	
	public void putDol(Omok omok){
		board[omok.getInX()][omok.getInY()] = omok.getDol();
	}


	
	public boolean isDol(int inX, int inY) {
		if(board[inX][inY].equals("○") || board[inX][inY].equals("●"))
			return true;
		return false;
	}

	public boolean isPut(int inX, int inY) { // 오목판 범위 && 이미 오목알이 존재하는지 검사함.
		if (inX > m-2 || inY > n-2) // 범위를 벗어난 수 입력
		{
			System.out.printf("x는 1~15, Y는 1~20 사이의 수를 입력해주세요.\n");
			return false;
		}
		else if (inX == -1 || inY == -1) // 0을 입력한 경우
		{
			System.out.printf("0은 입력 불가한 수입니다. 1 이상의 수를 입력해주세요.\n");
			return false;
		}	
		else {
			boolean isDol = isDol(inX,inY); // 해당 보드에 오목알이 존재하는지 검사 
			if (isDol)
			{
				System.out.println("이미 오목알이 존재합니다.. 다시 입력해주세요.\n");
				return false;
			}
			else // 범위 내에 존재하며, 오목알이 없는 경우 true반환
				return true;
		}
	}

	
	public void saveBackOmok(Omok omok) { // 기존의 값을 저장하기 위한 함수
		backX= omok.getInX(); // x좌표
		backY = omok.getInY() ;// y좌표
		backDol = board[backX][backY]; // 해당 위치의 값
	
	}


	public void setBackOmok(Omok omok) { // 한 수 무를 경우, 새로운 값에 기존의 값 대입
		board[omok.getInX()][omok.getInY()]=backDol; // 새 값 대입
		System.out.println(omok.getDolColor() + "의 한 수를 물렀습니다.");
		drawBoard();	
	}
	
		
	boolean checkWin(Omok omok) {
		boolean win = false;
		int inX = omok.getInX();
		int inY = omok.getInY();
		System.out.println("");
		
		// m=16  n=21
		if (inY >= 4 && inY < (n-1 - 4)) { // 범위 별로 보드를 9구간으로 나눠 검사한다.
			if (inX < 4) {
				win = (left(inX, inY) || right(inX, inY) || leftDown(inX, inY)
						|| down( inX, inY) || right(inX, inY));
			} else if (inX >= 4 && inX < (m-1 - 4)) {
				win = (left(inX, inY) || right(inX, inY) || leftDown(inX, inY)
						|| rightDown(inX, inY) || up(inX, inY) || down(inX, inY)
						|| leftUp(inX, inY) || rightUp(inX, inY));
			} else {
				win = (left(inX, inY) || right(inX, inY) || up(inX, inY) || leftUp(inX, inY)
						|| rightUp(inX, inY));
			}
		}

		else if (inY < 4) {
			if (inX < 4)
				win = (right(inX, inY) || rightDown(inX, inY) || down(inX, inY));

			else if (inX >= 4 && inX < (m-1 - 4))
				win = (right(inX, inY) || rightDown(inX, inY) || up(inX, inY)
						|| down(inX, inY) || rightUp(inX, inY));
			else
				win = (right(inX, inY) || up(inX, inY) || rightUp(inX, inY));
		}

		else {
			if (inX < 4)
				win = (left(inX, inY) || leftDown(inX, inY) || down(inX, inY));

			else if (inX >= 4 && inX < (m-1 - 4))
				win = (left(inX, inY) || leftDown(inX, inY) || up(inX, inY)
						|| down(inX, inY) || leftUp(inX, inY));
			else
				win = (left(inX, inY) || leftUp(inX, inY) || up(inX, inY));
		}

		return win;
	}

	
	//////////////////////////// 8방향으로 검사 ///////////////////////////////
	public boolean left(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX][inY - i]))
				count++;
		}

		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean right(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX][inY + i]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean up(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX - i][inY]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean down(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX + i][inY]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean leftUp(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX - i][inY - i]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean leftDown(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX + i][inY - i]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean rightUp(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX - i][inY + i]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}

	public boolean rightDown(int inX, int inY) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			if (board[inX][inY].equals(board[inX + i][inY + i]))
				count++;
		}
		if (count == 4)
			return true;
		else
			return false;

	}



	
}
