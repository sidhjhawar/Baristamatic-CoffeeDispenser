/*
 * Author: Sidharth Sitaram Jhawar, MS-CS, Indiana University Bloomington.
 * Class: BaristamaticMain -> Main class of the application.
 */

package com.baristamatic.main;

import java.util.Scanner;

import com.baristamatic.app.CoffeeMachineSimulator;

public class BaristamaticMain {

	public static void main(String[] args) {

		CoffeeMachineSimulator coffeeMachineSimulator = new CoffeeMachineSimulator();
		Scanner s = new Scanner(System.in);
		String userChoice;

		while (true) {
			coffeeMachineSimulator.displayInventoryMenu();
			userChoice = s.next();
			if (userChoice.equalsIgnoreCase("q"))
				break;
			else if (userChoice.equalsIgnoreCase("r"))
				coffeeMachineSimulator.restockInventory();
			else
				coffeeMachineSimulator.coffeeMachineDispenser(userChoice);
		}

	}

}
