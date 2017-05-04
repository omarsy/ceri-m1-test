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
	public void setUp() throws Exception { 
		MockitoAnnotations.initMocks(this);
		this.pokemon = PokemonTestFactory.genererPokemons(1).get(0);
		this.index = 0;
		this.cp = 1;
		this.hp = 1;
		this.dust = 1;
		this.candy = 1;
		
		Mockito.when(pokemonfactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(pokemon);
		Mockito.when(pokemonfactory.createPokemon(-1, cp, hp, dust, candy)).thenThrow(new Exception());
	
	} 
	@Test
	public void testCreate() throws Exception
	{
		assertEquals(this.pokemonfactory.createPokemon(index, cp, hp, dust, candy),this.pokemon);
	}
	@Test(expected=Exception.class)
	public void TestErreur() throws Exception
	{
		this.pokemonfactory.createPokemon(-1, cp, hp, dust, candy);
	}
}

