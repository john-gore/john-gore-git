
public class Wizard extends Human{
	public Wizard() {
		this.health = 300;
		this.intelligence = 8;
	}
	
	public void heal(Human h) {
		System.out.println("Healing!!!!");
		h.health = h.health + intelligence;
	}
	
	public void fireball(Human h) {
		System.out.println("Fireballing");
		h.health = h.health - (intelligence * 3);
	}
}
