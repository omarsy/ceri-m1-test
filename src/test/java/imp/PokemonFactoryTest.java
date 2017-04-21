package imp;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.imp.PokemonFactory;

public class PokemonFactoryTest extends IPokemonFactoryTest  {
	@Before 
	public void setUp() { 
		this.pokemonfactory = PokemonFactory.getInstance();
		this.pokemon = new Pokemon(0,"Bulbasaur",126,126,90,1459, 77, 2500,1,84.4000015258789);
		this.index = 0;
		this.cp = 1459;
		this.hp = 77;
		this.dust = 2500;
		this.candy = 1;
		
	
	
	} 
}
