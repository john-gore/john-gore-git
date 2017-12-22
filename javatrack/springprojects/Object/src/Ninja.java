
public class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(Human h) {
		System.out.println("Stealing!!!!");
		h.health = h.health - stealth;
		health = health + stealth;
	}
}
