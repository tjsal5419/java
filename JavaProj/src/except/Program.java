package except;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
			FileOutputStream fs = null;
			try {
				fs = new FileOutputStream("aa.txt");
				fs.write(52);
				Calculator.add(300, 300);
			} catch (FileNotFoundException e) {
				System.out.println("�˼��մϴ�. �Է��Ͻ� ������ ã�� �� �����ϴ�.");
			} catch (Exception e) {
				System.out.println("���� �߻�");
			} finally // ���� �۾� catch �� ���ٰ� finally �̵�.
			{
				System.out.println("�����۾�");
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}
}
