package SnakesAndLadder;

public class Dice {

	int noOfdice;
 
	public Dice(int noOfdice) {
		super();
		this.noOfdice = noOfdice;
	}

	public int onDiceRoll(int noOfdice) {
		int diceValue = noOfdice * (((int) (Math.random() * 6)) + 1);
		System.out.println("Your Dice value is ****" + diceValue);
		return diceValue;
	}

	public int onCrookedDiceRoll(int noOfdice) {
		int diceValue = -1;
		while (true) {
			diceValue = onDiceRoll(noOfdice);
			if (diceValue % 2 == 0) {
				break;
			}
		}
		System.out.println("Your crook Dice value is ****" + diceValue);
		return diceValue;
	}
}
