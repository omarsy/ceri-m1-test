package imp;

import java.io.IOException;
import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;
import fr.univavignon.pokedex.imp.Pokedex;
import fr.univavignon.pokedex.imp.PokedexFactory;
import fr.univavignon.pokedex.imp.PokemonFactory;
import fr.univavignon.pokedex.imp.PokemonMetadataProvider;

public class PokedexFactoryTest extends IPokedexFactoryTest {
	@Before 
	public void setUp() throws IOException  {
		
		this.pokedexfactory = PokedexFactory.getInstance();
		this.metadataProvider = PokemonMetadataProvider.getInstance();
		this.pokemonFactory = PokemonFactory.getInstance();
		this.pokedex = new Pokedex(this.metadataProvider,this.pokemonFactory);
	
	} 
}
