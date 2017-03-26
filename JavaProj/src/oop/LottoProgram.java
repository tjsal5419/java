package oop;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) throws IOException {

		int temp;
		//로또 생성
		int[] lotto = new int[6];
		
		//로또 번호 뽑기(6개 랜덤)
		genLotto(lotto);
		//로또 번호 출력
		printLotto(lotto);
		// 로또 번호 정렬
		sortLotto(lotto);
		// 로또 번호 출력
		printLotto(lotto);
		
		
		
	}
	
	public static void genLotto(int[] lotto){
		Random rand = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(45)+1;
		}
	}
	
	public static void printLotto(int[] lotto){
		for (int j = 0; j < 6; j++) {
			System.out.printf("%-4d", lotto[j]);
		} 
		System.out.println(); // 바꾼 수를 출력함.
		
	}
	
	public static void sortLotto(int[] lotto) {

		System.out.println("오름차순:");
		for (int h = 5; h > 0; h--){
			for (int i = 0; i < h; i++){ // 앞 뒤로 두 수를 비교함(5회 실행)
				if (lotto[i] > lotto[i + 1]) 
				{
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				} // 가장 큰 값을 찾는 정렬
			}
		}

	}
	
}
