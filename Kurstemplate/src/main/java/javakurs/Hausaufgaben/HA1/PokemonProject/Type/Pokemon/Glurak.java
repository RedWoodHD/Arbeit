package javakurs.Hausaufgaben.HA1.PokemonProject.Type.Pokemon;

import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;
import javakurs.Hausaufgaben.HA1.PokemonProject.Type.FirePokemon;

/**
 * Diese Klasse representiert ein {@link FirePokemon}.
 * Dieses ist in erster Linie wie ein das normale {@link Pokemon}, es ist vom Typos Feuer und hat dadurch Spezialangriffe
 * und ist auch gegen spezielle andere Typen besser oder schlechter geeignet.
 * @author EGA
 */
public class Glurak extends FirePokemon
{
    private String nickname;

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 66.
     *
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void explosiveVortex(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - 66);
    }

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben} um 66.
     *
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void flameThrower(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - 50);
    }

    public String getNickname()
    {
        return nickname;
    }

    public Glurak setNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }
}
