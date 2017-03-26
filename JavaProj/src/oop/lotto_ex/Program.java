package oop.lotto_ex;

public class Program {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.gen();
		lotto.sort();
		lotto.print();
	}

}
