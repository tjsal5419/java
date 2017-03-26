import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringProgram {
	public static void main(String[] args) throws IOException {
		/*
		 * String name1 = new String("아이유"); String name2="아이유";
		 * System.out.println(name1.equals(name2)); //==는 주소를 비교, equals는 문자열 비교
		 * System.out.println(name2=="아이유"); // 같은 값이므로 참조하여 같은 주소를 가져 true 반환함.
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
		 * String data = "강호동, 이경규, 설현"; String[] dataSplit = data.split(",");
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

			System.out.println("대본 출력 프로그램입니다.");
			System.out.println("───────────────────────────────────");
			System.out.println("1. 라인 번호 전체 출력");
			System.out.println("2. 단어 포함된 문장 출력 ");
			System.out.println("3. 라인 번호로 문장 출력");
			System.out.println("4. 시스템 종료");
			System.out.println("───────────────────────────────────");

			num = scanSys.nextInt();

			switch (num) {
			case 1: // 대사 전체 출력
				lineNum = 1; // 처음 시작할 문장 번호
				while (scan.hasNextLine()) {
					line = scan.nextLine();
					System.out.println("전체 대사 출력");
					System.out.println(lineNum + "번 대사 : " + line);
					lineNum++; // 다음 문장으로 이동하므로 라인 수 추가.
				}
				scan.close();
				fo.close();
				System.out.println("───────────────────────────────────");

				break;
			case 2: // 대사 단어 검색
				lineNum = 1; // 처음 시작할 문장 번호
				System.out.println("검색할 문장에 포함할 단어를 입력하세요.");
				queryLine = scanSys.nextLine();// 엔터 인식해서 하나 더 추가.
				queryLine = scanSys.nextLine(); // 검색할 단어 입력 받음.

				while (scan.hasNext()) {
					line = scan.nextLine();
					if (line.indexOf(queryLine) > 0) {
						System.out.println(lineNum + "번 대사 : " + line.replace(queryLine, "["+queryLine+"]"));
					} // 입력 받은 단어를 포함하는 경우 단어 출력
					lineNum++; // 다음 문장으로 이동하므로 라인 수 추가.
				}
				scan.close();
				fo.close();
				System.out.println("───────────────────────────────────");

				break;

			case 3:
				lineNum = 1; // 처음 시작할 문장 번호
				System.out.println("검색할 문장의 라인 번호를 입력해주세요.");
				queryNum = scanSys.nextInt(); // 검색할 문장 번호 입력 받음.
				while (scan.hasNext()) {
					line = scan.nextLine();
					if (lineNum == queryNum) {
						System.out.println("───────────────────────────────────");
						System.out.println(lineNum + "번 대사 : " + line);
					}
					lineNum++; // 다음 문장으로 이동하므로 라인 수 추가.
				}
				scan.close();
				fo.close();
				System.out.println("───────────────────────────────────");

				break;

			case 4:
				break Exit;
			default:
				System.out.println("잘못된 입력입니다. 1~3 사이의 숫자를 입력해주세요.");

			}

			fo.close();
			scan.close();

		}
		scanSys.close();
	}
}
