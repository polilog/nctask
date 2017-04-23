package model.ingredients;

public class Ingredient {
	private int id;
	private String name;
	private double caloricity;
	private double weight;
	
	public Ingredient(String name) {
		this.name = name;
	}

	public Ingredient(String name, double caloricity) {
		if (caloricity < 0)
			throw new IllegalArgumentException();
		this.name = name;
		this.caloricity = caloricity;
		this.weight = 100;
	}
	
	public Ingredient(String name, double caloricity, double weight) {
		if (caloricity < 0 || weight < 0)
			throw new IllegalArgumentException();
		this.name = name;
		this.caloricity = caloricity;
		this.weight = weight;
	}

	public void setId(int id) {this.id = id;}

	public int getId() {return id;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCaloricity() {
		return caloricity;
	}
	
	public void setCaloricity(double caloricity) {
		this.caloricity = caloricity;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weigh) {
		this.weight = weigh;
	}
	
	public double getCalories() {
		return caloricity * weight / 100;
	}
	
	@Override
	public String toString() {
		return name + ": " + getCalories() + " ���� " + weight + " �";
	}
	
}
