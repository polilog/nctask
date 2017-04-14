package model.salads;

import model.ingredients.Apple;
import model.ingredients.Banana;

public class FruitSalad extends Salad {

	public FruitSalad() {
		super("Fruit salad");
		addIngredient(new Apple(200));
		addIngredient(new Banana(100));
	}

}
