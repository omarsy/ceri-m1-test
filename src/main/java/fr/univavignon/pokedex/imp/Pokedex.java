package fr.univavignon.pokedex.imp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pokemon> pokemons;
	private IPokemonMetadataProvider pokemonMetadataProvider;
	private IPokemonFactory pokemonFactory;
	
	public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider,IPokemonFactory pokemonFactory ) 
	{
	
		this.pokemonMetadataProvider = pokemonMetadataProvider;
		this.pokemonFactory = pokemonFactory; 
		pokemons = new ArrayList<Pokemon>();
	}
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return this.pokemonMetadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws Exception {
		// TODO Auto-generated method stub
		return this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		this.pokemons.add(pokemon);
		return this.pokemons.size()  ;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		return this.pokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return this.pokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		ArrayList<Pokemon> listpokemons = new ArrayList<Pokemon>(this.pokemons.size());
		for(int i = 0 ; i < this.pokemons.size() ; i++)
		{
			int pos = 0;
			for(int j = 0 ; j < this.pokemons.size() ; j++)
			{
				if(i != j)
				{
					int valcomp = order.compare(this.pokemons.get(i), this.pokemons.get(j));
					if(valcomp > 0)
					{
						pos++;
					}
					else
						if(valcomp == 0 && i > j)
						{
							
								pos++;
							
						}
				}
			}
			listpokemons.add(pos, this.pokemons.get(i));
		}
				
		return listpokemons;
	}
	public static void save(Pokedex pokedex,String path) throws Exception
	{
		
		ObjectOutputStream oos = null;
		final FileOutputStream fichier = new FileOutputStream(path);
		oos = new ObjectOutputStream(fichier);
		oos.writeObject(pokedex);
		oos.flush();
		oos.close();
	}
	
	public static Pokedex charge(String path) throws Exception
	{
		ObjectInputStream ois = null;
		final FileInputStream fichier = new FileInputStream(path);
	    ois = new ObjectInputStream(fichier);
	    final Pokedex pokedex = (Pokedex) ois.readObject();
	    ois.close();
	    return pokedex;
	}
	@Override
	public boolean equals(Object poke)
	{
		Pokedex pokedex  = (Pokedex)poke;
		if(poke != null && this.size()  == pokedex.size() )
		{
			for(int i = 0 ; i < this.size() ; i++)
				try {
					if(!this.getPokemon(i).equals(pokedex.getPokemon(i)))
						return false;
				} catch (PokedexException e) {
					// TODO Auto-generated catch block
					return false;
				}
		}
		else {
			return false;
		}
				return true;
	}
}
