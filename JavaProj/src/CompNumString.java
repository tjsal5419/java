import java.util.Scanner;

public class CompNumString { // made by 선미 
	public static void main(String[] args){
		String[] num = new String[]{"0","1","2","3","4","5","6","7","8","9"};
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열을 입력해주세요");
		boolean isString = false;
		
		
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			char[] inputChar = new char[input.length()]; 
			inputChar = input.toCharArray();
			
			for(int i=0;i<num.length;i++)
				if(!input.contains(num[i]))
	     			isString=true;
					
			if(isString)
				System.out.println("문자열입니다.");
			else 
				System.out.println("숫자입니다.");
			
			System.out.println();
			System.out.println("문자열을 입력해주세요");
			isString = false;
		}
		scan.close();
		
}
}
