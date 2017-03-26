package oop.nested;

public class AA {
	
	public static int a1 ;
	private int x = 1;
	
	static{
		a1 = 10;
	}
	
	public AA() {
		a1 = 3;
	}
	
	public void f2(){
		a1 = 4;
		BB b = new BB(); // 받아온 객체를 this 로 접근할 수 있으면 인스턴스라고 한다.
	}
	
	public static void f3(){
		BB bb = new AA().new BB();
	}
	
	class BB{
		private int a1 = 5;
	
		public void f1(){
			int a1 = 7;
			
			System.out.printf("a1은 %d", AA.this.a1);
			
		}
	}
	
}
