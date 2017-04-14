package model.comparators;

import model.ingredients.Ingredient;

import java.util.Comparator;

public class WeightComparator implements Comparator<Ingredient>{

	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		return (int)(o1.getWeight() - o2.getWeight());
	}

}
