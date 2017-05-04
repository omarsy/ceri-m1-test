package imp;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.imp.Pokedex;
import fr.univavignon.pokedex.imp.PokedexFactory;
import fr.univavignon.pokedex.imp.PokemonFactory;
import fr.univavignon.pokedex.imp.PokemonMetadataProvider;

public class PokedexTest extends IPokedexTest{

	@Before 
	public void setUp() throws Exception { 
	
		this.pokedex = PokedexFactory.getInstance().createPokedex(PokemonMetadataProvider.getInstance(), PokemonFactory.getInstance());
		PokemonFactory pokemonFactory =  PokemonFactory.getInstance();
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		this.pokemonsGetIdTeste = new HashMap<Integer,Pokemon>();
		this.size = 2;
		for(int i = 0 ; i < this.size ; i++)
		{
			Pokemon pokemon = pokemonFactory.createPokemon(i,1459 ,77, 2500, 1);
			pokemons.add(pokemon);
			this.pokedex.addPokemon(pokemon);
			this.pokemonsGetIdTeste.put(i, pokemon);
		}
		
		this.pokemonListAAjoute = pokemons;
		this.pokemonsComparatorsCp = pokemons;
		this.pokemonsComparatorsIndex = pokemons;
		this.pokemonsComparatorsName = pokemons;
		this.pokemonsGetAll = pokemons;
		
	}
	@Test
	public void saveAndCharge() throws Exception
	{
		String path = "pokedex.test";
		Pokedex.save((Pokedex) this.pokedex, path);
		Pokedex newpok = Pokedex.charge(path);
		assertEquals(this.pokedex,newpok);
		
	}
	 @Test(expected=Exception.class)   
	 public void testChargeErreur() throws Exception {     
		  Pokedex.charge("dkdk");
		 }
	 
	 @Test(expected=Exception.class)   
	 public void testSaveErreur() throws Exception {     
		  Pokedex.save((Pokedex)this.pokedex,null);
		 }
}
