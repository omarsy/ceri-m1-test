package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {
	@Mock 
	protected IPokedexFactory pokedexfactory;
	
	protected IPokemonMetadataProvider metadataProvider;
	protected IPokemonFactory pokemonFactory;
	@Mock
	protected IPokedex pokedex;
	@Before 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		List<Pokemon> pokemons = PokemonTestFactory.genererPokemons(7);
		Mockito.when(pokedexfactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
		Mockito.when(pokedex.size()).thenReturn(pokemons.size());
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
	} 
	
	@Test()
	public void testSize()
	{
		IPokedex pokedexByFactory = this.getPokodexFactory();
		assertEquals(pokedex.size(),pokedexByFactory.size());
	}
	
	
	@Test()
	public void testEqualPokemon()
	{
		IPokedex pokedexByFactory = this.getPokodexFactory();
		for(int i = 0 ; i < pokedex.getPokemons().size() ; i++)
		{
			assertEquals(pokedex.getPokemons().get(i) , pokedexByFactory.getPokemons().get(i));
		}
	}
	
	public IPokedex getPokodexFactory()
	{
		return pokedexfactory.createPokedex(metadataProvider, pokemonFactory);
	}
}
