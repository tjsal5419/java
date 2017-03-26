import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		int[] remain = new int[]{0,0,0,0,0,0,0,0};		// 8bit로 표시
		int num, quot;
		int index = 0; 
		String binaryStr="";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("0~255사이의 수를 입력하여 2진법으로 출력합니다.");
		num = scan.nextInt();
		quot = num;
		
		for(int i=0; i<8; i++){
			if(quot==0){ // 몫이 1이 되면 for문 break
				break;
			}
			else{ // 몫이 1이 아니면 계속 몫을 2로 나눠줌.
				remain[i] = quot%2; // 나머지는 배열에 0번지부터 저장 
				quot = quot / 2;
			}
			
		}
		System.out.println();
		
		for(int j=7 ; j>=0; j--) // 저장한 배열 출력
			binaryStr = binaryStr+String.valueOf(remain[j]);
		
		System.out.println("───────────────────────");		
		System.out.printf("%d을 2진법으로 변환하면 %s입니다.",num,binaryStr);
		
	}

}
