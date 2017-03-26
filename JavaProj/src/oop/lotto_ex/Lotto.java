package oop.lotto_ex;

import java.util.Random;

public class Lotto {
	private int[] nums;
	
	public Lotto()
	{ // ������, �Լ�x, ��ü ������ �� �ѹ��� ����ȴ�
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
		System.out.println(); // �ٲ� ���� �����.
		
	}
	
	public void sort() 
	{

		System.out.println("��������:");
		for (int h = 5; h > 0; h--)
		{
			for (int i = 0; i < h; i++)
			{ // �� �ڷ� �� ���� ����(5ȸ ����)
				if (nums[i] > nums[i + 1]) 
				{
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				} // ���� ū ���� ã�� ����
			}
		}

	}
	
}
