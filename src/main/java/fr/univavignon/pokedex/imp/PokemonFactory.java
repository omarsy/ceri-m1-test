package fr.univavignon.pokedex.imp;

import java.io.Serializable;
import org.openqa.selenium.chrome.ChromeDriver;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.imp.pokemonoutil.CalculateurIv;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class PokemonFactory implements IPokemonFactory,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PokemonFactory instance;
	private PokemonFactory()
	{
		
	}
	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws Exception {
		// TODO Auto-generated method stub
		ChromeDriverManager.getInstance().setup();
		CalculateurIv ivcalcul = new CalculateurIv(new ChromeDriver());
		PokemonMetadata pokemonmetadata = PokemonMetadataProvider.getInstance().getPokemonMetadata(index);
		return new Pokemon(
					index,pokemonmetadata.getName()  ,pokemonmetadata.getAttack(),pokemonmetadata.getDefense(),pokemonmetadata.getStamina(),cp,hp,dust,candy,ivcalcul.getIv(pokemonmetadata.getName(), cp, hp, dust));
		
	}
	
	public static PokemonFactory getInstance()
	{
		if(instance == null)
			instance = new PokemonFactory();
		return instance;
	}
	
}
