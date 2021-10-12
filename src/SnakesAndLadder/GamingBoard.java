package SnakesAndLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class GamingBoard {

	int boardSize;
	Queue<Player> player;
	Dice dice;
	List<Jumper> Snakes;
	List<Jumper> ladders;
	HashMap<String, Integer> playerPos;

	public GamingBoard(int boardSize, Queue<Player> player, Dice dice, List<Jumper> snakes, List<Jumper> ladders,
			HashMap<String, Integer> playerPos) {

		this.boardSize = boardSize;
		this.player = player;
		this.dice = dice;
		Snakes = snakes;
		this.ladders = ladders;
		this.playerPos = playerPos;
	}

	public void gameOnForMultiPlayer() {

		while (player.size() > 1) {
			Player currentPlayer = player.poll();

			String currentPlayerName = currentPlayer.name;
			int currCellPos = playerPos.get(currentPlayerName);
			int diceValue = dice.onDiceRoll(dice.noOfdice);
			int nextcell = currCellPos + diceValue;

			if (nextcell > boardSize) {
				player.offer(currentPlayer);
			}

			else if (nextcell == boardSize) {
				System.out.println(currentPlayerName + " has won the game");
				break;

			} else {
				int[] nextpos = new int[1];
				nextpos[0] = nextcell;
				for (Jumper j : Snakes) {
					if (j.start == nextcell) {
						nextpos[0] = j.end;
						break;
					}
				}
				if (nextcell != nextpos[0]) {
					System.out
							.println(currentPlayerName + " got snakes at " + nextcell + " and moved to " + nextpos[0]);
				}
				boolean ladder = false;
				for (Jumper j : ladders) {
					if (j.start == nextcell) {
						nextpos[0] = j.end;
						ladder = true;
						break;
					}
				}
				if (nextcell != nextpos[0] && ladder) {
					System.out
							.println(currentPlayerName + " got ladders at " + nextcell + " and moved to " + nextpos[0]);
				}
				if (nextpos[0] == boardSize) {
					System.out.println(currentPlayerName + " has won the game");
					break;

				}

				playerPos.put(currentPlayerName, nextpos[0]);
				System.out.println(currentPlayerName + " is at position " + nextpos[0]);
				player.offer(currentPlayer);
			}
		}

		return;

	}

	public void gameOnForSinglePlayer(int n, String name) {
		int count = 0;
		while (count <= 10) {
			String currentPlayerName = name;
			;
			int currCellPos = playerPos.get(currentPlayerName);
			int diceValue = 0;
			if (n == 1) {
				diceValue = dice.onDiceRoll(dice.noOfdice);
			} else {
				diceValue = dice.onCrookedDiceRoll(dice.noOfdice);
			}
			int nextcell = currCellPos + diceValue;

			if (nextcell > boardSize) {
				System.out.println("next position is more than 100 ...throw  dice again ");
			}

			else if (nextcell == boardSize) {
				System.out.println("You  won the game");
				break;

			} else {
				int[] nextpos = new int[1];
				nextpos[0] = nextcell;
				for (Jumper j : Snakes) {
					if (j.start == nextcell) {
						nextpos[0] = j.end;
						break;
					}
				}
				if (nextcell != nextpos[0]) {
					System.out.println("You  got snakes at " + nextcell + " and moved to " + nextpos[0]);
				}
				boolean ladder = false;
				for (Jumper j : ladders) {
					if (j.start == nextcell) {
						nextpos[0] = j.end;
						ladder = true;
						break;
					}
				}
				if (nextcell != nextpos[0] && ladder) {
					System.out.println("You got ladders at " + nextcell + " and moved to " + nextpos[0]);
				}
				if (nextpos[0] == boardSize) {
					System.out.println("You won the game");
					break;

				}

				playerPos.put(currentPlayerName, nextpos[0]);
				System.out.println("You are at position " + nextpos[0] + " now");
			}
			count++;
		}
		System.out.println("Sorry, No of turn is more than 10!! , You can roll only 10 times");
		return;

	}

}
