package model.main;

import model.salads.FruitSalad;
import model.salads.Salad;

public class FruitSaladCook extends Cook {

	@Override
	public Salad createSalad() {
		return new FruitSalad();
	}

}
