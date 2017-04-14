package model.comparators;

import model.ingredients.Ingredient;

import java.util.Comparator;

public class CaloriesComparator implements Comparator<Ingredient>{

	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		return (int)(o1.getCalories() - o2.getCalories());
	}

}
