package except;

public class Calculator {
	public static int add(int x, int y) throws exceedHundred{  // ������ throw�� ���� ������ ���� ���� ���� ������, ������ �������� ������������
		int result = x + y;
		if(result > 100)
			throw new exceedHundred(); // ���⼭�� Ŭ������ ������ �˸��� ���� �ĺ��� 
		
		return result;
	}
	
	public static int sub(int x, int y){
		int result = x - y;
		return result;
	}
	
}
