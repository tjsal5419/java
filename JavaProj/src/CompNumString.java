import java.util.Scanner;

public class CompNumString { // made by ���� 
	public static void main(String[] args){
		String[] num = new String[]{"0","1","2","3","4","5","6","7","8","9"};
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڿ��� �Է����ּ���");
		boolean isString = false;
		
		
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			char[] inputChar = new char[input.length()]; 
			inputChar = input.toCharArray();
			
			for(int i=0;i<num.length;i++)
				if(!input.contains(num[i]))
	     			isString=true;
					
			if(isString)
				System.out.println("���ڿ��Դϴ�.");
			else 
				System.out.println("�����Դϴ�.");
			
			System.out.println();
			System.out.println("���ڿ��� �Է����ּ���");
			isString = false;
		}
		scan.close();
		
}
}
