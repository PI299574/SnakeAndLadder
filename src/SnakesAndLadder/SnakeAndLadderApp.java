package SnakesAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadderApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start the Ludo game *******");

		List<Jumper> snakes = new ArrayList<>();
		snakes.add(new Jumper(99, 13));
		snakes.add(new Jumper(60, 20));
		snakes.add(new Jumper(93, 35));
		snakes.add(new Jumper(33, 3));
		snakes.add(new Jumper(63, 34));

		List<Jumper> ladders = new ArrayList<>();
		ladders.add(new Jumper(10, 90));
		ladders.add(new Jumper(20, 85));
		ladders.add(new Jumper(30, 95));
		ladders.add(new Jumper(41, 54));
		ladders.add(new Jumper(34, 97));

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Snake and Ladder Game ***********");
		System.out.println("Enter Your Name *******");
		String name = sc.next();
		System.out.println("Welcome  *******" + name);
		System.out.println("Choose the Dice**************");
		System.out.println("press 1 for Normal dice**********");
		System.out.println("press 2 for crook dice**********");

		int n = 0;
		do {
			n = sc.nextInt();
			if (n == 1 || n == 2) {
				break;
			} else {
				System.out.println("Wrong Input!! Enter Again**********");
			}

		} while (true);
		System.out.println("How many no of dices need for playing******");
		int noOfdice = sc.nextInt();

		Dice noOfDice = new Dice(noOfdice);
		int boardSize = 100;

		Queue<Player> players = new LinkedList<>();
		players.add(new Player(1, name));
		HashMap<String, Integer> playerMap = new HashMap<>();
		playerMap.put(name, 0);
		GamingBoard board = new GamingBoard(boardSize, players, noOfDice, snakes, ladders, playerMap);
		// board.gameOn();
		board.gameOnForSinglePlayer(n, name);
	}

}
