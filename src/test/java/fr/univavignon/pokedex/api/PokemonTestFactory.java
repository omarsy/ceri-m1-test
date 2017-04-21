package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonTestFactory {
	public static List<Pokemon> genererPokemons(int nombre)
	{
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		for(int i = 0; i < nombre ; i++)
			pokemons.add(new Pokemon(i,"pokemon"+i,1,1,1,1,1,1,1,1));
		return pokemons;
	}
}
