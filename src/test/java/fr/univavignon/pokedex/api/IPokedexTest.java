package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



public  class IPokedexTest {
	@Mock 
	protected IPokedex pokedex;
	/**
	 * 
	 */
	protected List<Pokemon> pokemonListAAjoute;
	/**
	 * 
	 */
	protected Map<Integer,Pokemon> pokemonsGetIdTeste;
	/**
	 * 
	 */
	protected int size;
	/**
	 * 
	 */
	protected List<Pokemon> pokemonsGetAll;
	/**
	 * 
	 */
	protected List<Pokemon> pokemonsComparatorsName;
	/**
	 * 
	 */
	protected List<Pokemon> pokemonsComparatorsIndex;
	/**
	 * 
	 */
	protected List<Pokemon> pokemonsComparatorsCp;
	
	protected int idGetPokemonMetadata;
	
	protected PokemonMetadata valGetPokemonMetadata;
	protected Pokemon pokemonVerCreer;
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Before 
	public void setUp() throws PokedexException, IOException, Exception { 
		MockitoAnnotations.initMocks(this);
		size = 7;
		List<Pokemon> pokemons = PokemonTestFactory.genererPokemons(size);
		this.pokemonListAAjoute = pokemons;
		this.pokemonsComparatorsCp = pokemons;
		this.pokemonsComparatorsIndex = pokemons;
		this.pokemonsComparatorsName = pokemons;
		this.pokemonsGetAll = pokemons;
		this.pokemonsGetIdTeste = new HashMap<Integer,Pokemon>();
		this.idGetPokemonMetadata = 2;
		
		for(int i = 0 ; i < size ; i++)
		{
			Pokemon pokemon = pokemons.get(i);
			this.pokemonsGetIdTeste.put(i, pokemon);
			Mockito.when(pokedex.addPokemon(this.pokemonListAAjoute.get(i))).thenReturn(size + i +1);
			Mockito.when(pokedex.getPokemon(i)).thenReturn(pokemon);
			
		}
		this.pokemonVerCreer = pokemons.get(0);
		this.valGetPokemonMetadata = pokemons.get(this.idGetPokemonMetadata);
		Mockito.when(pokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemons);
		Mockito.when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
		Mockito.when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
		Mockito.when(pokedex.createPokemon(this.pokemonVerCreer.getIndex(), this.pokemonVerCreer.getCp(), this.pokemonVerCreer.getHp(), this.pokemonVerCreer.getDust(), this.pokemonVerCreer.getCandy())).thenReturn(this.pokemonVerCreer);
		Mockito.when(pokedex.getPokemonMetadata(this.idGetPokemonMetadata)).thenReturn(this.valGetPokemonMetadata);
	
	} 
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAddPokemon()
	{
		int size = pokedex.getPokemons().size();
		for(int i = 0; i < this.pokemonListAAjoute.size() ; i++)
			assertEquals(this.pokedex.addPokemon(this.pokemonListAAjoute.get(i)),size + i +1);
	}
	
	@Test
	public void testSize()
	{
		
		assertEquals(pokedex.getPokemons().size() , this.size);
	}
	@Test
	public void testGetPokemonId() throws PokedexException
	{
		for(Map.Entry<Integer, Pokemon> pokemon : this.pokemonsGetIdTeste.entrySet())
			assertEquals(this.pokedex.getPokemon(pokemon.getKey()),pokemon.getValue());
	}
	@Test
	public void testGetPokemons()
	{
		List<Pokemon> pokemons = this.pokedex.getPokemons();
		for(int i = 0 ; i < this.pokemonsGetAll.size() ; i++)
			assertEquals(this.pokemonsGetAll.get(i),pokemons.get(i));
	}
	@Test
	public void testGetPokemonsComparatorName()
	{
		List<Pokemon> pokemons = this.pokedex.getPokemons(PokemonComparators.NAME);
		for(int i = 0 ; i < this.pokemonsComparatorsName.size() ; i++)
			assertEquals(this.pokemonsComparatorsName.get(i),pokemons.get(i));
	}
	
	@Test
	public void testGetPokemonsComparatorIndex()
	{
		List<Pokemon> pokemons = this.pokedex.getPokemons(PokemonComparators.INDEX);
		for(int i = 0 ; i < this.pokemonsComparatorsIndex.size() ; i++)
			assertEquals(this.pokemonsComparatorsIndex.get(i),pokemons.get(i));
	}
	
	@Test
	public void testGetPokemonMetadata() throws PokedexException
	{
		assertEquals(this.pokedex.getPokemonMetadata(this.idGetPokemonMetadata),this.valGetPokemonMetadata);
	}
	@Test
	public void testCreatePokemon() throws Exception
	{
		assertEquals(this.pokedex.createPokemon(this.pokemonVerCreer.getIndex(), this.pokemonVerCreer.getCp(), this.pokemonVerCreer.getHp(), this.pokemonVerCreer.getDust(), this.pokemonVerCreer.getCandy()),this.pokemonVerCreer);
	}
	@Test
	public void testGetPokemonsComparatorCp()
	{
		List<Pokemon> pokemons = this.pokedex.getPokemons(PokemonComparators.CP);
		for(int i = 0 ; i < this.pokemonsComparatorsCp.size() ; i++)
			assertEquals(this.pokemonsComparatorsCp.get(i),pokemons.get(i));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
