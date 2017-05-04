package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactory  implements IPokemonTrainerFactory {
	private static PokemonTrainerFactory instance;
	private PokemonTrainerFactory()
	{
		
	}
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) throws Exception {
		// TODO Auto-generated method stub
		return new PokemonTrainer(name,team,pokedexFactory.createPokedex(PokemonMetadataProvider.getInstance(), PokemonFactory.getInstance()));
	}
	
	public static PokemonTrainerFactory getInstance()
	{
		if(instance == null)
			instance = new PokemonTrainerFactory();
		return instance;
	}
}
