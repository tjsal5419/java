import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringProgram {
	public static void main(String[] args) throws IOException {
		/*
		 * String name1 = new String("������"); String name2="������";
		 * System.out.println(name1.equals(name2)); //==�� �ּҸ� ��, equals�� ���ڿ� ��
		 * System.out.println(name2=="������"); // ���� ���̹Ƿ� �����Ͽ� ���� �ּҸ� ���� true ��ȯ��.
		 */

		/*
		 * String fileName = "photo.jpg"; System.out.println(fileName.length());
		 * System.out.println(fileName.indexOf("."));
		 * System.out.println(fileName.substring(0, 3)); int idx =
		 * fileName.indexOf("."); System.out.println(fileName.substring(0,
		 * idx));
		 * 
		 * int lastIdx = fileName.length(); int startIdx = fileName.indexOf(".")
		 * + 1; System.out.println(fileName.substring(startIdx, lastIdx));
		 * 
		 * String data = "��ȣ��, �̰��, ����"; String[] dataSplit = data.split(",");
		 * String dataCon = dataSplit[0] + dataSplit[2];
		 * System.out.println(dataCon); System.out.println(dataSplit[1]);
		 */

		FileInputStream fo;
		Scanner scan;
		Scanner scanSys = new Scanner(System.in);
		String line, queryLine;
		int lineNum = 1, num, queryNum;



		Exit: while (true) {
			fo = new FileInputStream("C:\\Users\\sist-c22\\Desktop\\Tools\\workspace\\JavaProj\\res\\script.txt");
			scan = new Scanner(fo);

			System.out.println("�뺻 ��� ���α׷��Դϴ�.");
			System.out.println("����������������������������������������������������������������������");
			System.out.println("1. ���� ��ȣ ��ü ���");
			System.out.println("2. �ܾ� ���Ե� ���� ��� ");
			System.out.println("3. ���� ��ȣ�� ���� ���");
			System.out.println("4. �ý��� ����");
			System.out.println("����������������������������������������������������������������������");

			num = scanSys.nextInt();

			switch (num) {
			case 1: // ��� ��ü ���
				lineNum = 1; // ó�� ������ ���� ��ȣ
				while (scan.hasNextLine()) {
					line = scan.nextLine();
					System.out.println("��ü ��� ���");
					System.out.println(lineNum + "�� ��� : " + line);
					lineNum++; // ���� �������� �̵��ϹǷ� ���� �� �߰�.
				}
				scan.close();
				fo.close();
				System.out.println("����������������������������������������������������������������������");

				break;
			case 2: // ��� �ܾ� �˻�
				lineNum = 1; // ó�� ������ ���� ��ȣ
				System.out.println("�˻��� ���忡 ������ �ܾ �Է��ϼ���.");
				queryLine = scanSys.nextLine();// ���� �ν��ؼ� �ϳ� �� �߰�.
				queryLine = scanSys.nextLine(); // �˻��� �ܾ� �Է� ����.

				while (scan.hasNext()) {
					line = scan.nextLine();
					if (line.indexOf(queryLine) > 0) {
						System.out.println(lineNum + "�� ��� : " + line.replace(queryLine, "["+queryLine+"]"));
					} // �Է� ���� �ܾ �����ϴ� ��� �ܾ� ���
					lineNum++; // ���� �������� �̵��ϹǷ� ���� �� �߰�.
				}
				scan.close();
				fo.close();
				System.out.println("����������������������������������������������������������������������");

				break;

			case 3:
				lineNum = 1; // ó�� ������ ���� ��ȣ
				System.out.println("�˻��� ������ ���� ��ȣ�� �Է����ּ���.");
				queryNum = scanSys.nextInt(); // �˻��� ���� ��ȣ �Է� ����.
				while (scan.hasNext()) {
					line = scan.nextLine();
					if (lineNum == queryNum) {
						System.out.println("����������������������������������������������������������������������");
						System.out.println(lineNum + "�� ��� : " + line);
					}
					lineNum++; // ���� �������� �̵��ϹǷ� ���� �� �߰�.
				}
				scan.close();
				fo.close();
				System.out.println("����������������������������������������������������������������������");

				break;

			case 4:
				break Exit;
			default:
				System.out.println("�߸��� �Է��Դϴ�. 1~3 ������ ���ڸ� �Է����ּ���.");

			}

			fo.close();
			scan.close();

		}
		scanSys.close();
	}
}
