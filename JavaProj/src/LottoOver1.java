import java.io.IOException;
import java.util.Random;

public class LottoOver1 {
	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		int swi;
		int anum[] = new int[10];
		
		System.out.println("<�ߺ����� ����ī�� ����>");
		for (int i = 0; i < 7; i++) {
			do {
				swi = 0;
				anum[i] = rand.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if (anum[i] == anum[j])	swi = 1;
				}
			} while (swi == 1);
			System.out.printf("%3d",anum[i]);
		}
	
		System.out.println("");
		System.out.println("");		
		System.out.println("<ī�� �������� ����>");
		int pis;
		for (int i = 0; i < 7; i++) {
			for (int j = i; j < 7; j++) {
				if (anum[i] > anum[j]) {
					pis = anum[j]; 
					anum[j] = anum[i];
					anum[i] = pis;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.printf("%3d", anum[i]);
		}
	}
}