package SnakesAndLadderTest;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import SnakesAndLadder.Dice;


public class DiceTest {

	@Test
	public void onDiceRollTest() {
		Dice dice = Mockito.spy(new Dice(2));
		int no = dice.onDiceRoll(2);

		assertTrue(no >= 2 && no <= 12);
	}

	@Test
	public void onDiceCrookRollTest() {
		Dice dice = Mockito.spy(new Dice(2));
		int no = dice.onCrookedDiceRoll(2);

		assertTrue(no % 2 == 0);
	}
}
