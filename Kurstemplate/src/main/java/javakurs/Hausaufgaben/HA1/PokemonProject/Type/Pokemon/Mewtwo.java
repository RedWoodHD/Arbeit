package javakurs.Hausaufgaben.HA1.PokemonProject.Type.Pokemon;

import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;
import javakurs.Hausaufgaben.HA1.PokemonProject.Type.PsychicPokemon;

public class Mewtwo extends PsychicPokemon
{
    private String nickname;

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 50.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void photonWave(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - 50);
    }

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 70.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void psyburn(Pokemon enemy)
    {
    enemy.setHealthPoints(enemy.getHealthPoints() - 70);
    }

    public String getNickname()
    {
        return nickname;
    }

    public Mewtwo setNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }
}
