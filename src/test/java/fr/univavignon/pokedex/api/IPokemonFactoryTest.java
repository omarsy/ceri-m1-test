package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonFactoryTest {
	@Mock
	protected IPokemonFactory pokemonfactory;
	protected Pokemon pokemon;
	protected int index;
	protected int cp;
	protected int hp;
	protected int dust;
	protected int candy;
	@Before 
	public void setUp() { 
		MockitoAnnotations.initMocks(this);
		this.pokemon = PokemonTestFactory.genererPokemons(1).get(0);
		this.index = 0;
		this.cp = 1;
		this.hp = 1;
		this.dust = 1;
		this.candy = 1;
		
		Mockito.when(pokemonfactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(pokemon);
	
	
	} 
	@Test
	public void testCreate()
	{
		assertEquals(this.pokemonfactory.createPokemon(index, cp, hp, dust, candy),this.pokemon);
	}

}

