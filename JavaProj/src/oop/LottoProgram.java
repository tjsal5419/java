package oop;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) throws IOException {

		int temp;
		//�ζ� ����
		int[] lotto = new int[6];
		
		//�ζ� ��ȣ �̱�(6�� ����)
		genLotto(lotto);
		//�ζ� ��ȣ ���
		printLotto(lotto);
		// �ζ� ��ȣ ����
		sortLotto(lotto);
		// �ζ� ��ȣ ���
		printLotto(lotto);
		
		
		
	}
	
	public static void genLotto(int[] lotto){
		Random rand = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(45)+1;
		}
	}
	
	public static void printLotto(int[] lotto){
		for (int j = 0; j < 6; j++) {
			System.out.printf("%-4d", lotto[j]);
		} 
		System.out.println(); // �ٲ� ���� �����.
		
	}
	
	public static void sortLotto(int[] lotto) {

		System.out.println("��������:");
		for (int h = 5; h > 0; h--){
			for (int i = 0; i < h; i++){ // �� �ڷ� �� ���� ����(5ȸ ����)
				if (lotto[i] > lotto[i + 1]) 
				{
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				} // ���� ū ���� ã�� ����
			}
		}

	}
	
}
