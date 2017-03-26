package oop.inherit;

import java.util.Scanner;

public class Omok {

	private int x;
	private int y;
	
	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("x(행) y(열)을 입력해주세요");
		x=scan.nextInt();
		y=scan.nextInt();
	}

	
}
