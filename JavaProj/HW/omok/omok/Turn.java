package omok.omok;

import java.util.Scanner;

public class Turn {
	private String turn; // ���� "0"�̸� �� ��, "1"�̸� ���� ��
	Turn() {
		turn = "0";
	}
	
	public String getTurn(){
		return turn;
	}
	
	public void selectTurn(Omok omok) {
		Scanner scan = new Scanner(System.in);
		
		while(true) // ໵��� �� ��� while ��
		{
			System.out.println("�浹(��)�� �Ͻ÷��� 1, �鵹(��)�� �Ͻ÷��� 0�� �Է����ּ���.");
			turn = scan.next();
			
			if (!turn.equals("0") && !turn.equals("1"))
				System.out.println("1�� 0 �߿� �Է����ּ���.");
			else
			{
				switch (turn) { // switch ���� break �ɾ������ ��! ��, �� ����
				case "0":
					omok.setDol("��"); // 0�� �鵹, 1�� �浹
					omok.setDolColor("�� ��");
					break;
				case "1":
					omok.setDol("��");
					omok.setDolColor("�� ��");
					break;
				}
				
				break;
			}
			
		}
		
	}
	public void changeTurn(Omok omok) {
		
		if (turn.equals("1")) // ��->���� �� ��ü
		{
			turn = "0";
			omok.setDol("��"); // 0�� �鵹, 1�� �浹
			omok.setDolColor("�� ��");
		}
		
		else
		{
			turn = "1";
			omok.setDol("��");
			omok.setDolColor("�� ��");
		}
	}
}
