package fr.univavignon.pokedex.api.imp;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.imp.PokemonOutil.CalculateurIv;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class PokemonFactory implements IPokemonFactory  {

	private static PokemonFactory instance;
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		ChromeDriverManager.getInstance().setup();
		CalculateurIv ivcalcul = new CalculateurIv(new ChromeDriver());
		try {
			PokemonMetadata pokemonmetadata = PokemonMetadataProvider.getInstance().getPokemonMetadata(index);
			return new Pokemon(
					index,pokemonmetadata.getName()  ,pokemonmetadata.getAttack(),pokemonmetadata.getDefense(),pokemonmetadata.getStamina(),cp,hp,dust,candy,ivcalcul.getIv(pokemonmetadata.getName(), cp, hp, dust));
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static PokemonFactory getInstance()
	{
		if(instance == null)
			instance = new PokemonFactory();
			return instance;
	}
	public static void main(String [] args)
	{
		ChromeDriverManager.getInstance().setup();
		CalculateurIv ivcalcul = new CalculateurIv(new ChromeDriver());
		System.out.println(ivcalcul.getIv("Bulbasaur", 1459, 77, 2500));
	}
}
