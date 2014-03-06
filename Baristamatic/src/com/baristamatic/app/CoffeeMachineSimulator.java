/*
 * Author: Sidharth Sitaram Jhawar, MS-CS, Indiana University Bloomington.
 * Class: CoffeeMachine -> Houses all the business logic for the Coffee Dispensing simulator.
 */
package com.baristamatic.app;

import java.util.ArrayList;
import java.util.List;

import com.baristamatic.model.Drink;
import com.baristamatic.model.Ingredient;

public class CoffeeMachineSimulator {

	public List<Drink> drinks;
	public List<Ingredient> ingredients;
	public static final int MAX_INVENTORY_LEVEL = 10;

	public CoffeeMachineSimulator() {

		drinks = initDrinks();
		ingredients = initIngredients(MAX_INVENTORY_LEVEL);

	}

	public void coffeeMachineDispenser(String option) {

		switch (option) {

		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
			dispenseDrink(option);
			break;

		default:
			System.out.println("Invalid Selection:" + option);
			break;

		}

	}

	public void dispenseDrink(String option) {

		Drink drink = drinks.get(Integer.parseInt(option) - 1);
		if (isDrinkAvailable(drink)) {
			System.out.println("Dispensing:" + drink.getDrinkName());
			for (Ingredient ing : drink.getIngredientList()) {
				for (Ingredient ingList : ingredients) {
					if (ing.getIngredientName() == ingList.getIngredientName()) {
						ingList.setUnits(ingList.getUnits() - ing.getUnits());
					}
				}
			}
		} else
			System.out.println("Out of Stock:" + drink.getDrinkName());

	}

	public void displayInventoryMenu() {
		showInventory();
		showMenu();
	}

	public void showMenu() {
		System.out.println("Menu:");
		for (Drink d : drinks) {
			System.out.println(d.getDrinkID() + "," + d.getDrinkName() + ",$"
					+ String.format("%.2f", d.getDrinkCost()) + ","
					+ isDrinkAvailable(d));
		}
	}

	public void showInventory() {

		System.out.println("Inventory:");
		for (Ingredient ing : ingredients) {
			System.out.println(ing.getIngredientName() + "," + ing.getUnits());
		}

	}

	public boolean isDrinkAvailable(Drink drink) {

		boolean result = false;
		for (Ingredient ing : drink.getIngredientList()) {
			for (Ingredient ingredient : ingredients) {
				if (ingredient.getIngredientName().equalsIgnoreCase(
						ing.getIngredientName())) {
					if (ingredient.getUnits() >= ing.getUnits())
						result = true;
					else
						return false;
				}
			}
		}
		return result;

	}

	public void restockInventory() {
		ingredients = initIngredients(MAX_INVENTORY_LEVEL);
	}

	public List<Ingredient> initIngredients(int stock) {

		List<Ingredient> ingredientList = new ArrayList<Ingredient>();

		Ingredient coffee = new Ingredient();
		coffee.setIngredientName("Coffee");
		coffee.setUnitCost(0.75f);
		coffee.setUnits(stock);

		Ingredient decafCoffee = new Ingredient();
		decafCoffee.setIngredientName("Decaf Coffee");
		decafCoffee.setUnitCost(0.75f);
		decafCoffee.setUnits(stock);

		Ingredient sugar = new Ingredient();
		sugar.setIngredientName("Sugar");
		sugar.setUnitCost(0.25f);
		sugar.setUnits(stock);

		Ingredient cream = new Ingredient();
		cream.setIngredientName("Cream");
		cream.setUnitCost(0.25f);
		cream.setUnits(stock);

		Ingredient steamedMilk = new Ingredient();
		steamedMilk.setIngredientName("Steamed Milk");
		steamedMilk.setUnitCost(0.35f);
		steamedMilk.setUnits(stock);

		Ingredient foamedMilk = new Ingredient();
		foamedMilk.setIngredientName("Foamed Milk");
		foamedMilk.setUnitCost(0.35f);
		foamedMilk.setUnits(stock);

		Ingredient espresso = new Ingredient();
		espresso.setIngredientName("Espresso");
		espresso.setUnitCost(1.10f);
		espresso.setUnits(stock);

		Ingredient cocoa = new Ingredient();
		cocoa.setIngredientName("Cocoa");
		cocoa.setUnitCost(0.90f);
		cocoa.setUnits(stock);

		Ingredient whippedCream = new Ingredient();
		whippedCream.setIngredientName("Whipped Cream");
		whippedCream.setUnitCost(1.00f);
		whippedCream.setUnits(stock);

		ingredientList.add(cocoa);
		ingredientList.add(coffee);
		ingredientList.add(cream);
		ingredientList.add(decafCoffee);
		ingredientList.add(espresso);
		ingredientList.add(foamedMilk);
		ingredientList.add(steamedMilk);
		ingredientList.add(sugar);
		ingredientList.add(whippedCream);

		return ingredientList;

	}

	public List<Drink> initDrinks() {

		List<Drink> drinkList = new ArrayList<Drink>();

		Drink cafeAmericano = new Drink();
		cafeAmericano.setDrinkID(1);
		cafeAmericano.setDrinkName("Cafe Americano");
		cafeAmericano.setIngredientList(prepareCafeAmericano());

		Drink cafeLatte = new Drink();
		cafeLatte.setDrinkID(2);
		cafeLatte.setDrinkName("Cafe Latte");
		cafeLatte.setIngredientList(prepareCafeLatte());

		Drink cafeMocha = new Drink();
		cafeMocha.setDrinkID(3);
		cafeMocha.setDrinkName("Cafe Mocha");
		cafeMocha.setIngredientList(prepareCafeMocha());

		Drink cappuccino = new Drink();
		cappuccino.setDrinkID(4);
		cappuccino.setDrinkName("Cappuccino");
		cappuccino.setIngredientList(prepareCappuccino());

		Drink coffee = new Drink();
		coffee.setDrinkID(5);
		coffee.setDrinkName("Coffee");
		coffee.setIngredientList(prepareCoffee());

		Drink decafCoffee = new Drink();
		decafCoffee.setDrinkID(6);
		decafCoffee.setDrinkName("Decaf Coffee");
		decafCoffee.setIngredientList(prepareDecafCoffee());

		drinkList.add(cafeAmericano);
		drinkList.add(cafeLatte);
		drinkList.add(cafeMocha);
		drinkList.add(cappuccino);
		drinkList.add(coffee);
		drinkList.add(decafCoffee);

		return drinkList;

	}

	public List<Ingredient> prepareCoffee() {

		List<Ingredient> coffeeIngredients = new ArrayList<Ingredient>();

		Ingredient coffee = new Ingredient();
		coffee.setIngredientName("Coffee");
		coffee.setUnitCost(0.75f);
		coffee.setUnits(3);

		Ingredient sugar = new Ingredient();
		sugar.setIngredientName("Sugar");
		sugar.setUnits(1);
		sugar.setUnitCost(0.25f);

		Ingredient cream = new Ingredient();
		cream.setIngredientName("Cream");
		cream.setUnitCost(0.25f);
		cream.setUnits(1);

		coffeeIngredients.add(coffee);
		coffeeIngredients.add(sugar);
		coffeeIngredients.add(cream);

		return coffeeIngredients;

	}

	public List<Ingredient> prepareDecafCoffee() {

		List<Ingredient> decafCoffeeIngredients = new ArrayList<Ingredient>();

		Ingredient decafCoffee = new Ingredient();
		decafCoffee.setIngredientName("Decaf Coffee");
		decafCoffee.setUnitCost(0.75f);
		decafCoffee.setUnits(3);

		Ingredient sugar = new Ingredient();
		sugar.setIngredientName("Sugar");
		sugar.setUnits(1);
		sugar.setUnitCost(0.25f);

		Ingredient cream = new Ingredient();
		cream.setIngredientName("Cream");
		cream.setUnitCost(0.25f);
		cream.setUnits(1);

		decafCoffeeIngredients.add(decafCoffee);
		decafCoffeeIngredients.add(sugar);
		decafCoffeeIngredients.add(cream);

		return decafCoffeeIngredients;

	}

	public List<Ingredient> prepareCafeLatte() {

		List<Ingredient> cafeLatteIngredients = new ArrayList<Ingredient>();

		Ingredient espresso = new Ingredient();
		espresso.setIngredientName("Espresso");
		espresso.setUnits(2);
		espresso.setUnitCost(1.10f);

		Ingredient steamMilk = new Ingredient();
		steamMilk.setIngredientName("Steamed Milk");
		steamMilk.setUnitCost(0.35f);
		steamMilk.setUnits(1);

		cafeLatteIngredients.add(espresso);
		cafeLatteIngredients.add(steamMilk);

		return cafeLatteIngredients;

	}

	public List<Ingredient> prepareCafeAmericano() {

		List<Ingredient> cafeAmericanoIngredients = new ArrayList<Ingredient>();

		Ingredient espresso = new Ingredient();
		espresso.setIngredientName("Espresso");
		espresso.setUnits(3);
		espresso.setUnitCost(1.10f);

		cafeAmericanoIngredients.add(espresso);

		return cafeAmericanoIngredients;

	}

	public List<Ingredient> prepareCafeMocha() {

		List<Ingredient> cafeMochaIngredients = new ArrayList<Ingredient>();

		Ingredient espresso = new Ingredient();
		espresso.setIngredientName("Espresso");
		espresso.setUnits(1);
		espresso.setUnitCost(1.10f);

		Ingredient steamMilk = new Ingredient();
		steamMilk.setIngredientName("Steam Milk");
		steamMilk.setUnitCost(0.35f);
		steamMilk.setUnits(1);

		Ingredient cocoa = new Ingredient();
		cocoa.setIngredientName("Cocoa");
		cocoa.setUnitCost(0.90f);
		cocoa.setUnits(1);

		Ingredient whippedCream = new Ingredient();
		whippedCream.setIngredientName("Whipped Cream");
		whippedCream.setUnitCost(1.00f);
		whippedCream.setUnits(1);

		cafeMochaIngredients.add(espresso);
		cafeMochaIngredients.add(steamMilk);
		cafeMochaIngredients.add(cocoa);
		cafeMochaIngredients.add(whippedCream);

		return cafeMochaIngredients;

	}

	public List<Ingredient> prepareCappuccino() {

		List<Ingredient> cafeMochaIngredients = new ArrayList<Ingredient>();

		Ingredient espresso = new Ingredient();
		espresso.setIngredientName("Espresso");
		espresso.setUnits(2);
		espresso.setUnitCost(1.10f);

		Ingredient steamMilk = new Ingredient();
		steamMilk.setIngredientName("Steam Milk");
		steamMilk.setUnitCost(0.35f);
		steamMilk.setUnits(1);

		Ingredient foamedMilk = new Ingredient();
		foamedMilk.setIngredientName("Foamed Milk");
		foamedMilk.setUnitCost(0.35f);
		foamedMilk.setUnits(1);

		cafeMochaIngredients.add(espresso);
		cafeMochaIngredients.add(steamMilk);
		cafeMochaIngredients.add(foamedMilk);

		return cafeMochaIngredients;

	}

}
