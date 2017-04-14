package model.main;

import model.salads.Salad;
import model.salads.VegetableSalad;

public class VegetableSaladCook extends Cook {

	@Override
	public Salad createSalad() {
		return new VegetableSalad();
	}

}
