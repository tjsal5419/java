package omok;
import java.util.Scanner;


public class OmokProgram2 { 	 // made by ����

	public static void main(String[] args) {
		// �����Ǳ׸���\
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		//�ʱ� ����
		
/*		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 && y == 0)
					Board[y][x] = '��';
				else if (x == 19 && y == 0)
					Board[y][x] = '��';
				else if (x == 0 && y == 14)
					Board[y][x] = '��';
				else if (x == 19 && y == 14)
					Board[y][x] = '��';
				else if (y == 0)
					Board[y][x] = '��';
				else if (y == 14)
					Board[y][x] = '��';
				else if (x == 19)
					Board[y][x] = '��';
				else if (x == 0)
					Board[y][x] = '��';
				else
					Board[y][x] = '��';

			}
		}*/

		Board board = new Board(); // �ʱ� ���� ����
		board.makeBoard(); //�ʱ� ���� ���� �� ��¥ ���忡 �־���;.
		
		char dol = 0;
		boolean mode = true;
		String color = null;
		String turn = "0";
		String back_to;
		Omok omok = new Omok();
			
		System.out.println("������������������������������Ӧ�����������������������");
		System.out.println("by ����\n");

		// ໵��� �� ��� while ��
		while (mode) 
		{
			board.board = board.board;
			for (int y = 0; y < 15; y++) {
				for (int x = 0; x < 20; x++)
					System.out.printf("%c", board.board[y][x]);
				System.out.println();
			}
			
			System.out.println("�浹(��)�� �Ͻ÷��� 1, �鵹(��)�� �Ͻ÷��� 0�� �Է����ּ���.");
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
					color = "�� ��"; // 0�� �鵹, 1�� �浹
					dol = '��';
					System.out.println();
					break;
				case "1":
					color = "�� ��";
					dol = '��';
					System.out.println();
					break;

			}

			System.out.println(color + " �� �����Դϴ�. (x sp y) : ");

			
			omok.inX = scan1.nextInt() - 1;
			omok.inY = scan1.nextInt() - 1;

			// ������ ���� ���� �Է� Ȯ��
			if (omok.inX > 14 || omok.inY > 19)
				System.out.printf("x�� 1~15, Y�� 1~20 ������ ���� �Է����ּ���.\n");
			else if (omok.inX == -1 || omok.inY == -1)
				System.out.printf("0�� �Է� �Ұ��� ���Դϴ�. 1 �̻��� ���� �Է����ּ���.\n");
			else {
				if (board.board[omok.inX][omok.inY] == '��' ||board.board[omok.inX][omok.inY] == '��')
					System.out.println("�̹� ������� �����մϴ�.. �ٽ� �Է����ּ���.\n");

				else // ���� �� ���� �� ���� ������
				{
					System.out.println("��������������������������������������������������");

					if (turn.equals("1")) // �� ���� �� ����
					{
						omok.backBlackX = omok.inX; // x��ǥ
						omok.backBlackY = omok.inY; // y��ǥ
						omok.backBlackDol = board.board[omok.inX][omok.inY]; // �ش� ��ġ�� ��
					}
					else // �� ���� �� ����
					{
						omok.backWhiteX = omok.inX;
						omok.backWhiteY = omok.inY;
						omok.backWhiteDol = board.board[omok.inX][omok.inY];
					}

					board.board[omok.inX][omok.inY] = dol; // �� ��ġ�� ���� ����.

					// ����ǥ ��� & �� �� ������

					for (int y = 0; y < 15; y++) {
						for (int x = 0; x < 20; x++)
							System.out.printf("%c", board.board[y][x]);
						System.out.println();
					}

					do { // [y/n]�� �ƴ� ��츦 �����ϱ� ���� do~while��
						System.out.println("�� �� �����ðڽ��ϱ�? [y/n]");
						back_to = scan2.nextLine();

						if (back_to.equals("y")) {
							if (turn.equals("1")) // ��, �� ���� ���� ���� �� ���� ������.
							{
								omok.inX = omok.backBlackX;
								omok.inY = omok.backBlackY;
								board.board[omok.inX][omok.inY] = omok.backWhiteDol;
							} else { // ���� ������ �ʰ� ���� �� ����
								omok.inX = omok.backWhiteX;
								omok.inY = omok.backWhiteY;
								board.board[omok.inX][omok.inY] = omok.backWhiteDol;
								System.out.println(color + "�� �� ���� �������ϴ�.");
							}


							for (int y = 0; y < 15; y++) { // ���� ���� ��, ���带 �׸���.
								for (int x = 0; x < 20; x++)
									System.out.printf("%c", board.board[y][x]);
								System.out.println();
							}
							checkWin(); // �¸� �˻� �Լ�
							
							break;
						}

						else if (back_to.equals("n")) // ���� ������ �ʰ� ���� �� ����
						{
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
	
	public static void checkWin() {
		for(int i=0 ; i++;)
		
	}
	
	}
