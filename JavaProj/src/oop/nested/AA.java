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
		BB b = new BB(); // �޾ƿ� ��ü�� this �� ������ �� ������ �ν��Ͻ���� �Ѵ�.
	}
	
	public static void f3(){
		BB bb = new AA().new BB();
	}
	
	class BB{
		private int a1 = 5;
	
		public void f1(){
			int a1 = 7;
			
			System.out.printf("a1�� %d", AA.this.a1);
			
		}
	}
	
}
