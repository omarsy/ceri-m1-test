 package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest 
{
	
	
	
	@Mock
	protected IPokemonTrainerFactory pokemonTrainerFactory;
	protected PokemonTrainer pokemonTrainer;
	protected String name; 
	protected Team team;
	@Mock
	protected IPokedexFactory pokedexFactory;

	@Before 
	public void setUp() throws Exception 
	{ 
		MockitoAnnotations.initMocks(this);
		this.name = "omar";
		this.team = Team.INSTINCT;
		Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(pokemonTrainer);
		Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, null)).thenThrow(new Exception());
	}
	
	@Test()
	public void testCreate() throws Exception
	{
		assertEquals(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory),this.pokemonTrainer);
	}

	@Test(expected=Exception.class)
	public void TestErreur() throws Exception
	{
		this.pokemonTrainerFactory.createTrainer(name, team, null);
	}
}
