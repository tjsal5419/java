import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOProgram {

	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream fo = new FileOutputStream(
		 * "C:\\Users\\sist-c22\\Desktop\\Tools\\workspace\\data.khw");
		 * PrintStream fout = new PrintStream(fo); fout.print("�ȳ��ϼ���");
		 * fout.close();
		 */
		FileInputStream fis = new FileInputStream("res/data.khw");
		Scanner scan = new Scanner(fis);
		int num;
		int sum = 0, count=0;

		/*for(int i=0;i<3;i++) {
			num = scan.nextInt();
			System.out.printf("���� : %d\n", num);
			sum = sum + num;
			System.out.printf("���� ��  : %d\n", sum);
		}*/
		
		while(scan.hasNext()){
			if(count<3){
			num = scan.nextInt();
			System.out.printf("���� : %d\n", num);
			sum = sum + num;
			System.out.printf("���� ��  : %d\n", sum);
			count++;
			}
			else
				break; 
		}

		System.out.println("����������������������������������������������������������������");
		System.out.printf("������ %d �Դϴ�.\n", sum);

		fis.close();
		scan.close();

		System.out.println("�۾�����");

	}
}
