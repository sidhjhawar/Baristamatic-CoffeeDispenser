/*
 * Author: Sidharth Sitaram Jhawar, MS-CS, Indiana University Bloomington.
 * Class: Ingredient -> A model class for an ingredient.Each ingredient is described by these fields and method.
 */
package com.baristamatic.model;

public class Ingredient {
	private String ingredientName;
	private float chargePerUnit;
	private int units;

	public float getTotalCost() {

		return units * chargePerUnit;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public float getUnitCost() {
		return chargePerUnit;
	}

	public void setUnitCost(float unitCost) {
		this.chargePerUnit = unitCost;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

}
