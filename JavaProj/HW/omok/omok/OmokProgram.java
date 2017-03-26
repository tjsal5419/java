package omok.omok;
import java.util.Scanner;

public class OmokProgram { 	 // made by ����

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String reStart;
		char a ;
		do{ // �ݺ� ������ ���� while�� 
		OmokStart();
		reStart = scan.nextLine(); // ����� ���� �Է¹޾ƿ�
			if(reStart.equals("n"))
			{
				System.out.println("������������������������������End!������������������������������");
				System.out.println("��������� �����մϴ�.");
				break;
			}
		}while(reStart.equals("y"));
	}
	
	public static void OmokStart(){
		// �����Ǳ׸���\
		Scanner scan1 = new Scanner(System.in);
		int m = 0;
		int n = 0; // �������� �׸��� ���� x,y ��ǥ 
		String strM, strN;
		boolean isString = true;
		// ��ü ����(����, ��, �����)
		System.out.println("��������������������������������������������������������������������\n");
		System.out.println("���� x��, ���� y�� �� �Է��� �������� �����ϼ���.");
		System.out.println("���� x��, ���� y�� �� �Է��� �������� �����ϼ���. (x enter y)");

		while(isString) // ��ǥ �� �Է� ���� -> ���ڸ� �Է� �ߴ���, �� ���� 7 �̻����� �˻�
		{
			System.out.println("�ܡۡܡۡܡۿ������� ����� ���ؼ��� 7 �̻��� ��ǥ ���� �Է����ּ���.�ܡۡܡۡܡ�");
			scan1 = new Scanner(System.in);
			strM = scan1.nextLine();
			strN = scan1.nextLine();

			if(StrToInt.isNum(strM) && StrToInt.isNum(strN))
			{
				m = StrToInt.changeNum(strM) +1; // ������ ��ȣ ���� �����, �Է� ���� 1�� �߰� 
				n = StrToInt.changeNum(strN) +1;
				if(m<8 && n<8)
					System.out.println("�ּ����� �������� ����� ���Ͽ� 7 �̻��� ��ǥ ���� �ʿ��մϴ�.");
				else
					isString = false;
			}
			else
				System.out.println("���ڸ� �Է����ֽñ� �ٶ��ϴ�.");
		}
		
		Board board = new Board(m, n);
		Omok omok = new Omok();
		Turn turn = new Turn();
		boolean start = true;
		
		// ���� �׷��ش�.
		board.drawBoard();

		System.out.println("");
		System.out.println("���δ� ��, ���δ� ���� (x,y)�� �Է����ּ���.");

		System.out.println("������������������������������������Ӧ�����������������������������");
		System.out.println("by ����\n");

		// ��, �� ���� ���� 
		turn.selectTurn(omok);
		
		
		System.out.println("������������������������������Start!������������������������������");
		System.out.println();
		while (start) 
		{ // ���� �ݺ��� ���� while��
			
			System.out.println();
			String dolColor = omok.getDolColor(); // ���� ���� ������
			String dol = omok.getDol(); // ���� ���� �� ������
			
			System.out.println(dolColor + " �� �����Դϴ�. (x enter y) : ");
			boolean isNum = true;
			int inX = 0;
			int inY =0;
			
			while(isNum)
			{				
				String strInX = scan1.nextLine();
				String strInY = scan1.nextLine();
				if(StrToInt.isNum(strInX) && StrToInt.isNum(strInY))
				{
					inX = StrToInt.changeNum(strInX) -1; // ������ ��ȣ ���� �����, �Է� ���� 1�� �߰� 
					inY = StrToInt.changeNum(strInY) -1;
					isNum = false;
				}
				else
					System.out.println("���ڸ� �Է����ּ���. (x enter y) ");
			}
		
/*			InputChangeInt xy = new InputChangeInt();
			xy.input();
			int inX = xy.getIntX();
			int inY = xy.getIntY();
			*/
			boolean isPut = board.isPut(inX,inY); // ����, ����� ���� �˻� ����
			
			if(isPut)
				{
					System.out.println("��������������������������������������������������������");
					omok.setXY(inX, inY); // X,Y�� ����
					board.saveBackOmok(omok); // �����⸦ ���� ���� ���� ���� ��(������ ��) ����
					board.putDol(omok); // �� ��ġ�� ���� ����.(���ο� �� �� ����)
					// ����ǥ ��� & �� �� ������

					board.drawBoard();
					String isBack;
					
					do { // [y/n]�� �ƴ� ��츦 �����ϱ� ���� do~while��
						System.out.println("�� �� �����ðڽ��ϱ�? [y/n]");
						isBack = scan1.nextLine();

						if (isBack.equals("y")) {
							board.setBackOmok(omok);	// ���� ���� ��������
							break;
						}

						else if (isBack.equals("n")) // ���� ������ �ʰ� ���� �� ����
						{
							
							if(board.checkWin(omok)){
								System.out.println("����������������������������������������������������������");
								System.out.printf("**********************%s�� �¸��Դϴ�.**********************\n", dolColor);
								System.out.println("����������������������������������������������������������");
								// ������ ���� �������� ���� ���� �߰��ؾ���!!
								System.out.println("������ ��� �����Ͻ÷��� y, �������� n�� �����ּ���.[y / n]");
								start=false;
								break;
							}
							turn.changeTurn(omok); //omok�� ���� �ٲ��ش�.
							break;
							
							
						}
						else // y, n �� �� �Է����� ���� ��� 
							System.out.println("y �Ǵ� n�� �Է����ּ���.");
						
					 } while (!isBack.equals("y") || !isBack.equals("n")); // do while �� ���ǹ�, y,n �� �� �Է����� ���� ���
				}

		}			
	}

}

