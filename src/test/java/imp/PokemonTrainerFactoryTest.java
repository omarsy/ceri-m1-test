package imp;

import java.io.IOException;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import fr.univavignon.pokedex.imp.PokedexFactory;
import fr.univavignon.pokedex.imp.PokemonFactory;
import fr.univavignon.pokedex.imp.PokemonMetadataProvider;
import fr.univavignon.pokedex.imp.PokemonTrainerFactory;

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
	@Before 
	public void setUp() throws IOException 
	{ 
		this.pokemonTrainerFactory = PokemonTrainerFactory.getInstance(); 
		this.name = "omar";
		this.team = Team.INSTINCT;
		this.pokedexFactory = PokedexFactory.getInstance();
		this.pokemonTrainer = new PokemonTrainer(name,team,this.pokedexFactory.createPokedex(PokemonMetadataProvider.getInstance(), PokemonFactory.getInstance()));
	}
}
