package omok.omok;

import java.util.Scanner;

public class Board {
	private String[][] board;
	private int m,n;
	private String isBack = null; // "y"�� ���, "n"�̸� �� �� ������
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
							board[y][x] = "/��";
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
					board[y][x] = "��";
				else if (x == (n-2) && y == 0)
					board[y][x] = "��";
				else if (x == 0 && y == (m-2))
					board[y][x] = "��";
				else if (x == (n-2) && y == (m-2))
					board[y][x] = "��";
				else if (y == 0)
					board[y][x] = "��";
				else if (y == (m-2))
					board[y][x] = "��";
				else if (x == (n-2))
					board[y][x] = "��";
				else if (x == 0)
					board[y][x] = "��";
				else
					board[y][x] = "��";

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
		if(board[inX][inY].equals("��") || board[inX][inY].equals("��"))
			return true;
		return false;
	}

	public boolean isPut(int inX, int inY) { // ������ ���� && �̹� ������� �����ϴ��� �˻���.
		if (inX > m-2 || inY > n-2) // ������ ��� �� �Է�
		{
			System.out.printf("x�� 1~15, Y�� 1~20 ������ ���� �Է����ּ���.\n");
			return false;
		}
		else if (inX == -1 || inY == -1) // 0�� �Է��� ���
		{
			System.out.printf("0�� �Է� �Ұ��� ���Դϴ�. 1 �̻��� ���� �Է����ּ���.\n");
			return false;
		}	
		else {
			boolean isDol = isDol(inX,inY); // �ش� ���忡 ������� �����ϴ��� �˻� 
			if (isDol)
			{
				System.out.println("�̹� ������� �����մϴ�.. �ٽ� �Է����ּ���.\n");
				return false;
			}
			else // ���� ���� �����ϸ�, ������� ���� ��� true��ȯ
				return true;
		}
	}

	
	public void saveBackOmok(Omok omok) { // ������ ���� �����ϱ� ���� �Լ�
		backX= omok.getInX(); // x��ǥ
		backY = omok.getInY() ;// y��ǥ
		backDol = board[backX][backY]; // �ش� ��ġ�� ��
	
	}


	public void setBackOmok(Omok omok) { // �� �� ���� ���, ���ο� ���� ������ �� ����
		board[omok.getInX()][omok.getInY()]=backDol; // �� �� ����
		System.out.println(omok.getDolColor() + "�� �� ���� �������ϴ�.");
		drawBoard();	
	}
	
		
	boolean checkWin(Omok omok) {
		boolean win = false;
		int inX = omok.getInX();
		int inY = omok.getInY();
		System.out.println("");
		
		// m=16  n=21
		if (inY >= 4 && inY < (n-1 - 4)) { // ���� ���� ���带 9�������� ���� �˻��Ѵ�.
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

	
	//////////////////////////// 8�������� �˻� ///////////////////////////////
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
