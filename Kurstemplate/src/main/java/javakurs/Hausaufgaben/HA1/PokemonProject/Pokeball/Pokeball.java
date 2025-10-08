package javakurs.Hausaufgaben.HA1.PokemonProject.Pokeball;

import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;
import javakurs.Hausaufgaben.HA1.PokemonProject.Trainer.Trainer;

import java.util.Random;

/**
 * Diese Klasse representiert einen Ball mit dem man {@link Pokemon} fangen kann.
 * @author EGA
 */
public class Pokeball
{
    private int buyPrice;
    private int sellPrice;
    private String ballClass;
    private Pokemon pokemon;
    private Trainer trainer;


    /**
     * Diese Methode entfernt das Pokemon. Dieses wird auf {@code null} gesetzt.
     */
    public void returnToWild()
    {
        pokemon = null;
    }

    /**
     * Diese Methode versucht das wildPokemon zu fangen.
     * @param wildPokemon das {@link Pokemon} dass gefangen werden soll.
     */
    public void attemptCapture(Pokemon wildPokemon)
    {
        Random rand = new Random();
        // Zufällig true oder false, wenn true dann wird das Pokemon gefangen.
        if (rand.nextBoolean()){
            pokemon = wildPokemon;
        }
    }

    public int getBuyPrice()
    {
        return buyPrice;
    }

    public Pokeball setBuyPrice(int buyPrice)
    {
        this.buyPrice = buyPrice;
        return this;
    }

    public int getSellPrice()
    {
        return sellPrice;
    }

    public Pokeball setSellPrice(int sellPrice)
    {
        this.sellPrice = sellPrice;
        return this;
    }

    public String getBallClass()
    {
        return ballClass;
    }

    public Pokeball setBallClass(String ballClass)
    {
        this.ballClass = ballClass;
        return this;
    }

    public Pokemon getPokemon()
    {
        return pokemon;
    }

    public Pokeball setPokemon(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        return this;
    }

    public Trainer getTrainer()
    {
        return trainer;
    }

    public Pokeball setTrainer(Trainer trainer)
    {
        this.trainer = trainer;
        return this;
    }
}
