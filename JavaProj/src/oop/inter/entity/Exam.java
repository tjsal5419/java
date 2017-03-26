package oop.inter.entity;
import java.util.Scanner;

public abstract class Exam {

	private int kor;
	private int eng;
	private int math; // ������ �Լ� �ȿ����� ����

	public Exam() { // ������ ����ȭ 
		this(10,10,10);
	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getKor() {
		return kor;
	}
	public void setKor(int kor){
		this.kor = kor;
	}
	
	public abstract float avg();
	
	public int total() {
		return kor+eng+math;
	}

}
