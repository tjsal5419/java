package omok;
import java.util.Scanner;

public class OmokProgram { 	 // made by ����

	public static void main(String[] args) {
		// �����Ǳ׸���\
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
					board[y][x] = "��";
				else if (x == 19 && y == 0)
					board[y][x] = "��";
				else if (x == 0 && y == 14)
					board[y][x] = "��";
				else if (x == 19 && y == 14)
					board[y][x] = "��";
				else if (y == 0)
					board[y][x] = "��";
				else if (y == 14)
					board[y][x] = "��";
				else if (x == 19)
					board[y][x] = "��";
				else if (x == 0)
					board[y][x] = "��";
				else
					board[y][x] = "��";

			}
		}
		

		for (int y = 0; y < 16; y++) {
			for (int x = 0; x < 21; x++)
				System.out.printf("%s", board[y][x]);
			System.out.println();
		}
		System.out.println("");
		System.out.println("���δ� ��, ���δ� ���� (x,y)�� �Է����ּ���.");
		
		String dol = "0";
		boolean mode = true;
		String dolColor = null;
		int inX, inY;
		String turn = "0";
		String back_to;
		int back_white_x = 0, back_white_y = 0, back_black_x = 0, back_black_y = 0;
		String back_white=null, back_black = null;

		System.out.println("������������������������������Ӧ�����������������������");
		System.out.println("by ����\n");

		while (mode) // ໵��� �� ��� while ��
		{
			System.out.println("�浹�� �Ͻ÷��� 1, �鵹�� �Ͻ÷��� 0�� �Է����ּ���.");
			turn = scan1.next();

			if (!turn.equals("0") && !turn.equals("1"))
				System.out.println("1�� 0 �߿� �Է����ּ���.");
			else
				mode = false;
		}
		System.out.println("������������������������Start!������������������������");
		System.out.println();
		while (true) { // ���� �ݺ��� ���� while��

			switch (turn) { // switch ���� break �ɾ������ ��! ��, �� ����
			case "0":
				dolColor = "�� ��"; // 0�� �鵹, 1�� �浹
				dol = "��";
				System.out.println();
				break;
			case "1":
				dolColor = "�� ��";
				dol = "��";
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
				if (board[inX][inY].equals("��") || board[inX][inY].equals("��"))
					System.out.println("�̹� ������� �����մϴ�.. �ٽ� �Է����ּ���.\n");

				else // ���� �� ���� �� ���� ������
				{
					System.out.println("��������������������������������������������������");

					if (turn.equals("1")) // �� ���� �� ����
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

					for (int y = 0; y < 16; y++) {
						for (int x = 0; x < 21; x++)
							System.out.printf("%s", board[y][x]);
						System.out.println();
					}

					do { // [y/n]�� �ƴ� ��츦 �����ϱ� ���� do~while��
						System.out.println("�� �� �����ðڽ��ϱ�? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn.equals("1")) // ��, �� ���� ���� ���� �� ���� ������.
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

							for (int y = 0; y < 16; y++) {
								for (int x = 0; x < 21; x++)
									System.out.printf("%s", board[y][x]);
								System.out.println();
							}
							break;
						}

						else if (back_to.endsWith("n")) // ���� ������ �ʰ� ���� �� ����
						{
							if(checkWin(board, inX, inY)){
								System.out.println("����������������������������������������������");
								System.out.printf("*****************%s�� �¸��Դϴ�.*****************\n", dolColor);
								System.out.println("����������������������������������������������");
								// ������ ���� �������� ���� ���� �߰��ؾ���!!
								System.out.println("������ ��� �����Ͻðڽ��ϱ�?");
								break;
							}
							
							if (turn.equals("1")) // ��->�� ��ü
								turn = "0";
							else
								turn = "1";
							break;
						} else
							System.out.println("y �Ǵ� n�� �Է����ּ���.");
						
					} while (!back_to.equals("y") || !back_to.equals("n"));
				}

			}
		}

	}

// �¸��� �Ǻ��ϴ� �Լ�
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


// �¸� �˻縦 ���� �Լ�..
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
