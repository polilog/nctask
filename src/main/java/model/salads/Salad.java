package model.salads;

import model.ingredients.Ingredient;
import model.comparators.CaloriesComparator;
import model.comparators.WeightComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {
	private String name;
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public Salad() {
		name = "No name";
	}
	
	public Salad(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean addIngredient(Ingredient ingredient) {
		return ingredients.add(ingredient);
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public double countCalories() {
		double calories = 0;
		for (Ingredient ingredient : ingredients) {
			calories += ingredient.getCalories();
		}
		return calories;
	}

	public double countWeight() {
		double weight = 0;
		for (Ingredient ingredient : ingredients) {
			weight += ingredient.getWeight();
		}
		return weight;
	}
	
	public void showIngredients() {
		if (ingredients.isEmpty()) {
			System.out.println("Ingredient's list is empty");
		}
		
		System.out.println(name);
		for (Ingredient ingredient : ingredients) {
			System.out.println(ingredient.toString());
		}
		System.out.println("Calories: " + countCalories());
	}
	
	public void sortIngredientsByCalories() {
		Collections.sort(ingredients, new CaloriesComparator());
	}
	
	public void sortIngredientsByWeight() {
		Collections.sort(ingredients, new WeightComparator());
	}
	
	public void chooseIngredientsByCalories(double lowerValue, double upperValue) {
		System.out.println("Ingredients from range");
		double calories;
		for (Ingredient ingredient : ingredients) {
			calories = ingredient.getCalories();
			if (calories >= lowerValue && calories <= upperValue) {
				System.out.println(ingredient.getName() + " "
						+ ingredient.getCalories() + " kkal");
			}
		}
	}
}
