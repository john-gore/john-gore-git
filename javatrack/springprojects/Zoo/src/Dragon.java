
public class Dragon extends Mammal{
	public Dragon() {
		this.energyLevel = 300;
	}
	public void fly() {
		System.out.println("Flying!!!!");
		this.energyLevel = energyLevel - 50;
	}

	public void eatHumans() {
		System.out.println("More Humans!!!!");
		this.energyLevel = energyLevel + 25;
	}

	public void attacktown() {
		System.out.println("Goin to town!!!");
		this.energyLevel = energyLevel - 100;
	}
}
