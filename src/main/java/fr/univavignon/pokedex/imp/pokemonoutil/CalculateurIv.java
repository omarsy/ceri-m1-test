package fr.univavignon.pokedex.imp.pokemonoutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculateurIv {
	 private static final String  URL = "https://pokeassistant.com/main/ivcalculator?locale=en";
	    private WebDriver driver;
	        public CalculateurIv(WebDriver driver ) {
			this.driver = driver;       
	    }
	    public double getIv(String name, int cp, int hp, int dust) {

	        driver.get(URL);
	        driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
	        driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
	        driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
	        driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
	        driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
	      
	        while(driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")) == null);
	        String resultat = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
	        driver.quit();
	        return Float.parseFloat(resultat.replace("%", ""));
	    }
}
