package omok;

import java.util.Scanner;

public class Board {
	
	int x,y;
	char[][] board = new char[15][20];
	

	public void makeBoard() {
/*		Scanner scan = new Scanner(System.in);
		System.out.println("�������� �׸� x, y�� �Է����ּ���. (x by y)");
		x = scan.nextInt();
		y= scan.nextInt();*/
		
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 && y == 0)
					board[y][x] = '��';
				else if (x == 19 && y == 0)
					board[y][x] = '��';
				else if (x == 0 && y == 14)
					board[y][x] = '��';
				else if (x == 19 && y == 14)
					board[y][x] = '��';
				else if (y == 0)
					board[y][x] = '��';
				else if (y == 14)
					board[y][x] = '��';
				else if (x == 19)
					board[y][x] = '��';
				else if (x == 0)
					board[y][x] = '��';
				else
					board[y][x] = '��';

			}
		}
		
	}

	public void firstDraw() {
		

			
		
	}

}
