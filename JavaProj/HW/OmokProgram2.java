import java.util.Scanner;

public class OmokProgram2 { 	 // made by ����

	public static void main(String[] args) {
		// �����Ǳ׸���\
		char[][] board = new char[15][20];
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

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

		char dol = 0;
		boolean mode = true;
		String dolColor = null;
		int inX, inY;
		int turn = 0;
		String back_to;
		int back_white_x = 0, back_white_y = 0, back_black_x = 0, back_black_y = 0;
		char back_white = 0, back_black = 0;

		System.out.println("������������������������������Ӧ�����������������������");
		System.out.println("by ����\n");

		while (mode) // ໵��� �� ��� while ��
		{
			System.out.println("�浹�� �Ͻ÷��� 1, �鵹�� �Ͻ÷��� 0�� �Է����ּ���.");
			turn = scan1.nextInt();

			if (turn != 1 && turn != 0)
				System.out.println("1�� 0 �߿� �Է����ּ���.");
			else
				mode = false;
		}
		System.out.println("������������������������Start!������������������������");
		System.out.println();
		while (true) { // ���� �ݺ��� ���� while��

			switch (turn) { // switch ���� break �ɾ������ ��! ��, �� ����
			case 0:
				dolColor = "�� ��"; // 0�� �鵹, 1�� �浹
				dol = '��';
				System.out.println();
				break;
			case 1:
				dolColor = "�� ��";
				dol = '��';
				System.out.println();
				break;

			}

			System.out.println(dolColor + " �� �����Դϴ�. (x sp y) : ");

			inX = scan1.nextInt() - 1;
			inY = scan1.nextInt() - 1;

			if (inX > 14 || inY > 19)
				System.out.printf("x�� 1~15, Y�� 1~20 ������ ���� �Է����ּ���.\n");
			else if (inX == -1 || inY == -1)
				System.out.printf("0�� �Է� �Ұ��� ���Դϴ�. 1 �̻��� ���� �Է����ּ���.\n");
			else {
				if (board[inX][inY] == '��' || board[inX][inY] == '��')
					System.out.println("�̹� ������� �����մϴ�.. �ٽ� �Է����ּ���.\n");

				else // ���� �� ���� �� ���� ������
				{
					System.out.println("��������������������������������������������������");

					if (turn == 1) // �� ���� �� ����
					{
						back_black_x = inX; // x��ǥ
						back_black_y = inY; // y��ǥ
						back_black = board[inX][inY]; // �ش� ��ġ�� ��
					}
					else // �� ���� �� ����
					{
						back_white_x = inX;
						back_white_y = inY;
						back_white = board[inX][inY];
					}

					board[inX][inY] = dol; // �� ��ġ�� ���� ����.

					// ����ǥ ��� & �� �� ������

					for (int y = 0; y < 15; y++) {
						for (int x = 0; x < 20; x++)
							System.out.printf("%c", board[y][x]);
						System.out.println();
					}

					do { // [y/n]�� �ƴ� ��츦 �����ϱ� ���� do~while��
						System.out.println("�� �� �����ðڽ��ϱ�? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn == 1) // ��, �� ���� ���� ���� �� ���� ������.
							{
								inX = back_black_x;
								inY = back_black_y;
								board[inX][inY] = back_black;
							} else {
								inX = back_white_x;
								inY = back_white_y;
								board[inX][inY] = back_white;
							}

							System.out.println(dolColor + "�� �� ���� �������ϴ�.");

							for (int y = 0; y < 15; y++) {
								for (int x = 0; x < 20; x++)
									System.out.printf("%c", board[y][x]);
								System.out.println();
							}
							break;
						}

						else if (back_to.endsWith("n")) // ���� ������ �ʰ� ���� �� ����
						{
							if(checkWin(board, inX, inY)){
								System.out.println(dolColor + "�� �̰��");
								break;
							}
							
							if (turn == 1) // ��->�� ��ü
								turn = 0;
							else
								turn = 1;
							break;
						} else
							System.out.println("y �Ǵ� n�� �Է����ּ���.");
						
					} while (!back_to.equals("y") || !back_to.equals("n"));
				}

			}
		}

	}

public static boolean checkWin(char[][] board, int inX, int inY) {
		boolean win = false;
		System.out.println("�¸��� �˻��ϴ� �Լ��Դϴ�.");
		
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
