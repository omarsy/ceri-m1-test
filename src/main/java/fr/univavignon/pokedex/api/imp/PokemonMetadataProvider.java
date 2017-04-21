package fr.univavignon.pokedex.api.imp;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import org.apache.commons.io.IOUtils;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	private static PokemonMetadataProvider instance ;
	private List<PokemonMetadata> pokemonMetadatas;
	private static final String URL ="https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		if(index < 0 || index >= this.pokemonMetadatas.size())
			throw new PokedexException("Pokedex Exception");
		return this.pokemonMetadatas.get(index);
	}
	private PokemonMetadataProvider() throws IOException
	{
		URL oracle = new URL(URL);
		URLConnection yc = oracle.openConnection();  
		String genreJson = IOUtils.toString(yc.getInputStream(),"UTF-8");
		this.pokemonMetadatas = new ArrayList<PokemonMetadata>();  
		JSONArray listMetadata = new JSONArray(genreJson);
		for(int i = 0 ; i < listMetadata.length(); i++)
		{
		    	JSONObject jsonMetadata = new JSONObject(listMetadata.get(i).toString());
		    	pokemonMetadatas.add(new PokemonMetadata(Integer.parseInt((String) jsonMetadata.get("PkMn")) -1, 
		    	(String) jsonMetadata.get("Identifier"), 
		    	Integer.parseInt((String)jsonMetadata.get("BaseAttack")),
		    	Integer.parseInt((String) jsonMetadata.get("BaseDefense")),
		    	Integer.parseInt((String)jsonMetadata.get("BaseStamina"))    
				));
		}
	}
	public static PokemonMetadataProvider getInstance() throws IOException {
		
		if(instance == null)
			instance = new PokemonMetadataProvider();
		return instance;
	}
	
	
}
