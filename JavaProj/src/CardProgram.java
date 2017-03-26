import java.util.Random;

public class CardProgram {

	public static void main(String[] args) {
		int[] cards = new int[52];
		Random rand = new Random();	
		int left, right, temp;
		
		for(int i=0;i<52;i++)
			cards[i] = i+1;
		
		System.out.println("변화 전 카드");
		for(int i=0;i<52;i++)
			System.out.printf("%3d",cards[i]);
		System.out.println();
		
		
		for(int i=0;i<100;i++){
			do{
				right = rand.nextInt(52); // 0~51
				left = rand.nextInt(52);
				
			}while(right==left);
			temp = cards[left];
			cards[left] = cards[right];
			cards[right] = temp;
		}

		System.out.println("변화 후 카드");
		for(int i=0;i<52;i++)
			System.out.printf("%3d",cards[i]);

		
	}

}
