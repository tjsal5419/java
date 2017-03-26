package oop.abstrac.entity;
import java.util.Scanner;

public abstract class Exam {

	private int kor;
	private int eng;
	private int math; // 선언은 함수 안에서만 가능

	public Exam() { // 생성자 집중화 
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
	
	public abstract float avg(); // avg는 ExamConsole에서 서비스를 하는 함수이므로 protected 가 아니라 public 으로 해줘야함.
	
	public int total() {
		return kor+eng+math;
	}

}
