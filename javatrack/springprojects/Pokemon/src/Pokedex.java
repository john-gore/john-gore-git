
public class Pokedex {
	@Override
	public String pokemonInfo(Pokemon pokemon) {
		return "Name: " + pokemon.getName() + ", Type: " + pokemon.getType() + ", Health: " + pokemon.getHealth();
	}
}
