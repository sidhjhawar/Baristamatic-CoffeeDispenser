/*
 * Author: Sidharth Sitaram Jhawar, MS-CS, Indiana University Bloomington.
 * Class: Drink -> A model class for a drink.Each drink is described by these fields and method.
 */
package com.baristamatic.model;

import java.util.List;

import com.baristamatic.model.Ingredient;

public class Drink {

	private List<Ingredient> ingredientList;
	private String drinkName;
	private int drinkID;

	public Double getDrinkCost() {

		Double totalCost = 0.0;
		for (Ingredient ing : ingredientList) {
			totalCost += ing.getTotalCost();
		}

		return totalCost;

	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkID() {
		return drinkID;
	}

	public void setDrinkID(int drinkID) {
		this.drinkID = drinkID;
	}

}
