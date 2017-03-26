package oop.nested;

import oop.nested.AA.BB;

public class Program {

	public static void main(String[] args) {
/*		AA aa = new AA();
		AA aaa = new AA();
		
		BB bb = aa.new BB();
		bb.f1();*/
		new AA();
		
		System.out.println(AA.a1);
		
		for (String string : args) {
			
		}
		
		for (int i = 0; i < args.length; i=i+2) {
			
		}
	}

}
