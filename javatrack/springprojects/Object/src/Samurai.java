
public class Samurai extends Human {
		private int health = 200;
		private static int counter;
		
	public Samurai() {
		this.health = 200;
		counter++;
	}
	
	public void deathBlow(Human h) {
		System.out.println("Death!!!!");
		h.health = 0;
		health = health / 2;
	}
	
	public void meditate() {
		System.out.println("Healing!!!!");
		health = health * 2;
	}
	
	public static void howMany() {
		System.out.println("There are " + counter + "Samurias");
	}
}
