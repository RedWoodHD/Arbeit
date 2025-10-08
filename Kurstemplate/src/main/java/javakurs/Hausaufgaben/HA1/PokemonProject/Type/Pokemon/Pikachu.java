package javakurs.Hausaufgaben.HA1.PokemonProject.Type.Pokemon;

import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;
import javakurs.Hausaufgaben.HA1.PokemonProject.Type.ElectroPokemon;

public class Pikachu extends ElectroPokemon
{
    private String nickname;

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 45.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void thunder(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - 45);
    }

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 65.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void megaThunderbolt(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - 65);
    }

    public String getNickname()
    {
        return nickname;
    }

    public Pikachu setNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }
}
