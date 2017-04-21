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
	public void setUp() 
	{ 
		MockitoAnnotations.initMocks(this);
		this.name = "omar";
		this.team = Team.INSTINCT;
		Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(pokemonTrainer);
	
	}
	
	@Test()
	public void testCreate()
	{
		assertEquals(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory),this.pokemonTrainer);
	}


}
