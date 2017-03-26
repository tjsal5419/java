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
				System.out.println("죄송합니다. 입력하신 파일을 찾을 수 없습니다.");
			} catch (Exception e) {
				System.out.println("문제 발생");
			} finally // 정리 작업 catch 절 갔다가 finally 이동.
			{
				System.out.println("정리작업");
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}
}
