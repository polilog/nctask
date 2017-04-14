package model.salads;

import model.ingredients.Carrot;
import model.ingredients.Cucumber;
import model.ingredients.Tomato;

public class VegetableSalad extends Salad {

	public VegetableSalad() {
		super("Vegetable salad");
		addIngredient(new Cucumber(200));
		addIngredient(new Carrot(100));
		addIngredient(new Tomato(100));
	}
}
