package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;


/**
 * 
 * @author Omar
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class IPokemonMetadataProviderTest {
	@Mock 
	protected IPokemonMetadataProvider pokemonMetaDataProvider;
	/**
	 * Listes pokemons
	 * @author Omar
	 */
	protected List<PokemonMetadata> pokemonMetadata ;
	protected List<Integer> listIndexAvecErreur;
	
	
	@Before 
	public void setUp() throws PokedexException  { 
		MockitoAnnotations.initMocks(this);
		this.listIndexAvecErreur = new ArrayList<Integer>();
		this.listIndexAvecErreur.add(-1);
		this.listIndexAvecErreur.add(233);
		pokemonMetadata = new ArrayList<PokemonMetadata>();
		pokemonMetadata.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		pokemonMetadata.add(new PokemonMetadata(133,"Aquali",186,168,260));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Pokedex Exception"));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(233)).thenThrow(new PokedexException("Pokedex Exception"));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata.get(0));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadata.get(1));
		} 
	 @Test(expected=PokedexException.class)   
	 public void testPokemonNotFoundException() throws PokedexException {     
		for(Integer index : this.listIndexAvecErreur)
		 	pokemonMetaDataProvider.getPokemonMetadata(index);
	
		 }
	 /**
	  * Test du retour de données du metaprovider
	  * @throws PokedexException
	  * @author Omar
	  */
	 @Test()
	 public void testPokemonFound() throws PokedexException
	 {
		 for(PokemonMetadata pokemondata : pokemonMetadata)
			 assertEquals(this.pokemonMetaDataProvider.getPokemonMetadata(pokemondata.getIndex()),pokemondata);
		 
	 }
}
