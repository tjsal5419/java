import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		int[] remain = new int[]{0,0,0,0,0,0,0,0};		// 8bit�� ǥ��
		int num, quot;
		int index = 0; 
		String binaryStr="";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("0~255������ ���� �Է��Ͽ� 2�������� ����մϴ�.");
		num = scan.nextInt();
		quot = num;
		
		for(int i=0; i<8; i++){
			if(quot==0){ // ���� 1�� �Ǹ� for�� break
				break;
			}
			else{ // ���� 1�� �ƴϸ� ��� ���� 2�� ������.
				remain[i] = quot%2; // �������� �迭�� 0�������� ���� 
				quot = quot / 2;
			}
			
		}
		System.out.println();
		
		for(int j=7 ; j>=0; j--) // ������ �迭 ���
			binaryStr = binaryStr+String.valueOf(remain[j]);
		
		System.out.println("����������������������������������������������");		
		System.out.printf("%d�� 2�������� ��ȯ�ϸ� %s�Դϴ�.",num,binaryStr);
		
	}

}
