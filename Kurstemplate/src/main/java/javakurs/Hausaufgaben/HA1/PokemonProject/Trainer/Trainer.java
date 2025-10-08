package javakurs.Hausaufgaben.HA1.PokemonProject.Trainer;

import javakurs.Hausaufgaben.HA1.PokemonProject.Pokeball.Pokeball;
import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;

/**
 * Diese Klasse representiert eine Person die {@link Pokemon} sammeln kann, um diese im Kampf zu nutzen.
 * Diese Klasse wird vom Anwender als spielbaren Charakter genutzt.
 * @author EGA
 */
public class Trainer
{
    private String name;
    private String rank;
    private Pokemon[] team;
    private Pokeball[] pokeballs;

    /**
     * Diese Methode gibt "Hallo!" auf der Konsole aus.
     */
    public void speak()
    {
        System.out.println("Hallo!");
    }

    public String getName()
    {
        return name;
    }

    public Trainer setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getRank()
    {
        return rank;
    }

    public Trainer setRank(String rank)
    {
        this.rank = rank;
        return this;
    }

    public Pokemon[] getTeam()
    {
        return team;
    }

    public Trainer setTeam(Pokemon[] team)
    {
        this.team = team;
        return this;
    }

    public Pokeball[] getPokeballs()
    {
        return pokeballs;
    }

    public Trainer setPokeballs(Pokeball[] pokeballs)
    {
        this.pokeballs = pokeballs;
        return this;
    }
}
