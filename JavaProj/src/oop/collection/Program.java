package oop.collection;

import java.util.ArrayList;

public class Program {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(new Exam());
		
		int x =(int)list.get(1);
	
		System.out.println("done");
	}
}
