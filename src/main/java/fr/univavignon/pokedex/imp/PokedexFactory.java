package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

public class PokedexFactory implements IPokedexFactory {
	private static PokedexFactory instance; 
	private PokedexFactory()
	{
		
	}
	public static PokedexFactory getInstance()
	{
		if(instance == null)
			instance = new PokedexFactory();
		return instance;
	}
	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		// TODO Auto-generated method stub
		return new Pokedex(metadataProvider,pokemonFactory);
	}
}
