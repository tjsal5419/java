package oop.lotto_ex;

import java.util.Random;

public class Lotto {
	private int[] nums;
	
	public Lotto()
	{ // 생성자, 함수x, 객체 생성시 단 한번만 실행된다
		nums = new int[6];
	}
	
	public void gen()
	{
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			nums[i] = rand.nextInt(45)+1;
	}
	
	public void print()
	{
		for (int j = 0; j < 6; j++)
			System.out.printf("%-4d", nums[j]);
		System.out.println(); // 바꾼 수를 출력함.
		
	}
	
	public void sort() 
	{

		System.out.println("오름차순:");
		for (int h = 5; h > 0; h--)
		{
			for (int i = 0; i < h; i++)
			{ // 앞 뒤로 두 수를 비교함(5회 실행)
				if (nums[i] > nums[i + 1]) 
				{
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				} // 가장 큰 값을 찾는 정렬
			}
		}

	}
	
}
