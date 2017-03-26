package except;

public class Calculator {
	public static int add(int x, int y) throws exceedHundred{  // 오류를 throw한 곳에 오류가 제일 먼저 오기 때문에, 생성한 곳에서는 던져버려야함
		int result = x + y;
		if(result > 100)
			throw new exceedHundred(); // 여기서의 클래스는 오류를 알리기 위한 식별자 
		
		return result;
	}
	
	public static int sub(int x, int y){
		int result = x - y;
		return result;
	}
	
}
